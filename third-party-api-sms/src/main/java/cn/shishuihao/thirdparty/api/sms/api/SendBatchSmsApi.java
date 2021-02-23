package cn.shishuihao.thirdparty.api.sms.api;

import cn.shishuihao.thirdparty.api.sms.SmsApi;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface SendBatchSmsApi extends SmsApi<SendBatchSmsApi, SendBatchSmsRequest, SendBatchSmsResponse> {
    /**
     * get api type
     * immutable
     *
     * @return api type
     */
    @Override
    default Class<SendBatchSmsApi> apiType() {
        return SendBatchSmsApi.class;
    }
}
