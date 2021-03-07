package cn.shishuihao.thirdparty.api.sms.tencent.api;

import cn.shishuihao.thirdparty.api.sms.api.SendSmsApi;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsApiResponse;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsApiResponse;
import lombok.AllArgsConstructor;

import java.util.Collections;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class TencentSendSmsApi implements SendSmsApi {
    /**
     * tencent sms api.
     */
    private final TencentSendBatchSmsApi tencentSendBatchSmsApi;

    /**
     * execute SendSmsApiRequest by tencent.
     *
     * @param request request
     * @return SendSmsApiResponse
     */
    @Override
    public SendSmsApiResponse execute(final SendSmsApiRequest request) {
        SendBatchSmsApiRequest sbRequest = SendBatchSmsApiRequest.builder()
                .channelId(request.channelId())
                .propertiesId(request.getPropertiesId())
                .templateId(request.getTemplateId())
                .messages(Collections.singletonList(request.getMessage()))
                .build();
        SendBatchSmsApiResponse sbResponse = tencentSendBatchSmsApi
                .execute(sbRequest);
        return SendSmsApiResponse.builder()
                .requestId(sbResponse.getRequestId())
                .success(sbResponse.isSuccess())
                .code(sbResponse.getSendStatuses()[0].getCode())
                .message(sbResponse.getSendStatuses()[0].getMessage())
                .build();
    }
}
