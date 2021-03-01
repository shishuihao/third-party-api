package cn.shishuihao.thirdparty.api.sms.tencent.api;

import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.sms.api.SendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.domain.SendStatus;
import cn.shishuihao.thirdparty.api.sms.domain.SmsMessage;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsApiResponse;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsApiProperties;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class TencentSendBatchSmsApi implements SendBatchSmsApi {
    @Override
    public SendBatchSmsApiResponse execute(SendBatchSmsApiRequest request) {
        TencentSmsApiProperties properties = (TencentSmsApiProperties) ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            /* 必要步骤：
             * 实例化一个认证对象，入参需要传入腾讯云账户密钥对 secretId 和 secretKey
             * 本示例采用从环境变量读取的方式，需要预先在环境变量中设置这两个值
             * 您也可以直接在代码中写入密钥对，但需谨防泄露，不要将代码复制、上传或者分享给他人
             * CAM 密钥查询：https://console.cloud.tencent.com/cam/capi
             */
            Credential cred = new Credential(properties.getSecretId(), properties.getSecretKey());
            /* 非必要步骤:
             * 实例化一个客户端配置对象，可以指定超时时间等配置 */
            ClientProfile clientProfile = new ClientProfile();
            /* SDK 默认用 TC3-HMAC-SHA256 进行签名
             * 非必要请不要修改该字段 */
            clientProfile.setSignMethod("HmacSHA256");
            /* 实例化 SMS 的 client 对象第二个参数是地域信息，可以直接填写字符串 ap-guangzhou，或者引用预设的常量 */
            SmsClient client = new SmsClient(cred, "", clientProfile);
            /* 实例化一个请求对象，根据调用的接口和实际情况，可以进一步设置请求参数
             * 您可以直接查询 SDK 源码确定接口有哪些属性可以设置
             * 属性可能是基本类型，也可能引用了另一个数据结构
             * 推荐使用 IDE 进行开发，可以方便地跳转查阅各个接口和数据结构的文档说明 */
            com.tencentcloudapi.sms.v20190711.models.SendSmsRequest req = new com.tencentcloudapi.sms.v20190711.models.SendSmsRequest();
            /* 填充请求参数，这里 request 对象的成员变量即对应接口的入参
             * 您可以通过官网接口文档或跳转到 request 对象的定义处查看请求参数的定义
             * 基本类型的设置:
             * 帮助链接：
             * 短信控制台：https://console.cloud.tencent.com/smsv2
             * sms helper：https://cloud.tencent.com/document/product/382/3773 */
            req.setSmsSdkAppid(properties.getAppId());
            req.setSign(properties.getSign());
            req.setSenderId(properties.getSenderId());
            req.setExtendCode(properties.getExtendCode());
            /* 模板 ID: 必须填写已审核通过的模板 ID，可登录 [短信控制台] 查看模板 ID */
            req.setTemplateID(request.getTemplateId());
            /* 下发手机号码，采用 e.164 标准，+[国家或地区码][手机号]
             * 例如+8613711112222， 其中前面有一个+号 ，86为国家码，13711112222为手机号，最多不要超过200个手机号*/
            req.setPhoneNumberSet(request.getMessages().stream()
                    .map(SmsMessage::getPhoneNumber).toArray(String[]::new));
            /* 模板参数: 若无模板参数，则设置为空*/
            req.setTemplateParamSet(request.getMessages().stream()
                    .map(it -> it.getTemplateParams().values().toArray(new String[0]))
                    .findFirst()
                    .orElseGet(() -> new String[]{""}));
            /* 通过 client 对象调用 SendSms 方法发起请求。注意请求方法名与请求对象是对应的
             * 返回的 res 是一个 SendSmsResponse 类的实例，与请求对象对应 */
            com.tencentcloudapi.sms.v20190711.models.SendSmsResponse sendSmsResponse = client.SendSms(req);
            return SendBatchSmsApiResponse.Builder.builder()
                    .requestId(sendSmsResponse.getRequestId())
                    .success(Arrays.stream(sendSmsResponse.getSendStatusSet()).allMatch(it -> "Ok".equals(it.getCode())))
                    .code(Arrays.stream(sendSmsResponse.getSendStatusSet())
                            .map(com.tencentcloudapi.sms.v20190711.models.SendStatus::getCode)
                            .collect(Collectors.joining()))
                    .message(Arrays.stream(sendSmsResponse.getSendStatusSet())
                            .map(com.tencentcloudapi.sms.v20190711.models.SendStatus::getMessage)
                            .collect(Collectors.joining()))
                    .sendStatuses(Arrays.stream(sendSmsResponse.getSendStatusSet())
                            .map(it -> new SendStatus(it.getCode(), it.getMessage()))
                            .toArray(SendStatus[]::new))
                    .build();
        } catch (TencentCloudSDKException e) {
            throw new ApiException(e);
        }
    }
}
