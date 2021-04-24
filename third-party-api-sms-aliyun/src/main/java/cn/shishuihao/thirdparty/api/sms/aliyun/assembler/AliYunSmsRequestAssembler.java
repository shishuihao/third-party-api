package cn.shishuihao.thirdparty.api.sms.aliyun.assembler;

import cn.shishuihao.thirdparty.api.commons.json.GsonUtils;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiProperties;
import cn.shishuihao.thirdparty.api.sms.domain.SmsMessage;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsApiRequest;
import com.aliyun.dysmsapi20170525.models.SendBatchSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 请求装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSmsRequestAssembler {
    /**
     * 实例.
     */
    public static final AliYunSmsRequestAssembler INSTANCE
            = new AliYunSmsRequestAssembler();

    /**
     * 装配 请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link SendSmsRequest}
     */
    public SendSmsRequest assemble(
            final SendSmsApiRequest request,
            final AliYunSmsApiProperties properties) {
        final SendSmsRequest alyRequest = new SendSmsRequest();
        Optional.ofNullable(request.getMessage()).ifPresent(message -> {
            alyRequest.setPhoneNumbers(message.getPhoneNumber());
            alyRequest.setSignName(Optional
                    .ofNullable(message.getSignName())
                    .orElseGet(properties::getSignName));
            alyRequest.setTemplateCode(request.getTemplateId());
            alyRequest.setTemplateParam(GsonUtils
                    .toJson(message.getTemplateParams()));
            alyRequest.setSmsUpExtendCode(Optional
                    .ofNullable(message.getExtendCode())
                    .orElseGet(properties::getSmsUpExtendCode));
        });
        return alyRequest;
    }

    /**
     * 装配 请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link SendBatchSmsRequest}
     */
    public SendBatchSmsRequest assemble(
            final SendBatchSmsApiRequest request,
            final AliYunSmsApiProperties properties) {
        final SendBatchSmsRequest sbRequest = new SendBatchSmsRequest();
        Optional.ofNullable(request.getMessages()).ifPresent(messages -> {
            sbRequest.setPhoneNumberJson(GsonUtils
                    .toJson(messages.stream()
                            .map(SmsMessage::getPhoneNumber)
                            .collect(Collectors.toList())));
            sbRequest.setSignNameJson(GsonUtils
                    .toJson(messages.stream()
                            .map(it -> Optional.ofNullable(it.getSignName())
                                    .orElseGet(properties::getSignName))
                            .collect(Collectors.toList())));
            sbRequest.setTemplateCode(request.getTemplateId());
            sbRequest.setTemplateParamJson(GsonUtils
                    .toJson(messages.stream()
                            .map(SmsMessage::getTemplateParams)
                            .collect(Collectors.toList())));
            sbRequest.setSmsUpExtendCodeJson(GsonUtils
                    .toJson(messages.stream()
                            .map(SmsMessage::getExtendCode)
                            .collect(Collectors.toList())));
        });
        return sbRequest;
    }
}
