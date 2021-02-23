package cn.shishuihao.thirdparty.api.sms.tencent.api;

import cn.shishuihao.thirdparty.api.sms.api.SendSmsApi;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsRequest;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsResponse;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsResponse;

import java.util.Collections;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class TencentSendSmsApi implements SendSmsApi {
    private final TencentSendBatchSmsApi tencentSendBatchSmsApi;

    public TencentSendSmsApi(TencentSendBatchSmsApi tencentSendBatchSmsApi) {
        this.tencentSendBatchSmsApi = tencentSendBatchSmsApi;
    }

    @Override
    public SendSmsResponse execute(SendSmsRequest request) {
        SendBatchSmsRequest smsRequest = SendBatchSmsRequest.Builder.builder()
                .channelId(request.channelId())
                .propertiesId(request.getPropertiesId())
                .phoneNumbers(Collections.singletonList(request.getPhoneNumber()))
                .templateId(request.getTemplateId())
                .templateParams(request.getTemplateParams())
                .build();
        SendBatchSmsResponse sendBatchSmsResponse = tencentSendBatchSmsApi.execute(smsRequest);
        return SendSmsResponse.Builder.builder()
                .code(sendBatchSmsResponse.getSendStatuses()[0].getCode())
                .message(sendBatchSmsResponse.getSendStatuses()[0].getMessage())
                .requestId(sendBatchSmsResponse.getRequestId())
                .build();
    }
}
