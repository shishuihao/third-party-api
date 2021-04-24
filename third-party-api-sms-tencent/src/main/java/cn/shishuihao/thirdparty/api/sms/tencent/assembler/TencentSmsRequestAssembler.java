package cn.shishuihao.thirdparty.api.sms.tencent.assembler;

import cn.shishuihao.thirdparty.api.sms.domain.SmsMessage;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsApiProperties;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;

import java.util.Collections;

/**
 * 请求装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class TencentSmsRequestAssembler {
    /**
     * 实例.
     */
    public static final TencentSmsRequestAssembler INSTANCE
            = new TencentSmsRequestAssembler();

    /**
     * 装配 请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link SendSmsRequest}
     */
    public SendSmsRequest assemble(
            final SendBatchSmsApiRequest request,
            final TencentSmsApiProperties properties) {
        final SendSmsRequest req = new SendSmsRequest();
        req.setSmsSdkAppid(properties.getAppId());
        req.setSign(properties.getSign());
        req.setSenderId(properties.getSenderId());
        req.setExtendCode(properties.getExtendCode());
        req.setTemplateID(request.getTemplateId());
        req.setPhoneNumberSet(request.getMessages().stream()
                .map(SmsMessage::getPhoneNumber).toArray(String[]::new));
        req.setTemplateParamSet(request.getMessages()
                .stream()
                .map(it -> it.getTemplateParams().values()
                        .toArray(new String[0]))
                .findFirst()
                .orElseGet(() -> new String[]{""}));
        return req;
    }

    /**
     * 装配 请求.
     *
     * @param request 请求
     * @return {@link SendBatchSmsApiRequest}
     */
    public SendBatchSmsApiRequest assemble(
            final SendSmsApiRequest request) {
        return SendBatchSmsApiRequest.builder()
                .channelId(request.channelId())
                .appId(request.getAppId())
                .templateId(request.getTemplateId())
                .messages(Collections.singletonList(request.getMessage()))
                .build();
    }
}
