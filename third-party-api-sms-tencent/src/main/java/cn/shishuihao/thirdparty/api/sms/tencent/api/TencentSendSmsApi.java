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
        SendBatchSmsRequest smsRequest = new SendBatchSmsRequest()
                .setChannelId(request.channelId())
                .setPropertiesId(request.getPropertiesId())
                .setPhoneNumbers(Collections.singletonList(request.getPhoneNumber()))
                .setTemplateId(request.getTemplateId())
                .setTemplateParams(request.getTemplateParams());
        SendBatchSmsResponse smsResponse = tencentSendBatchSmsApi.execute(smsRequest);
        return new SendSmsResponse()
                .setCode(smsResponse.getSendStatuses()[0].getCode())
                .setMessage(smsResponse.getSendStatuses()[0].getMessage())
                .setRequestId(smsResponse.getRequestId());
    }
}
