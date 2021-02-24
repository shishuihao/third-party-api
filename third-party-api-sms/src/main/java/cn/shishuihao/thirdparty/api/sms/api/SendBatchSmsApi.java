package cn.shishuihao.thirdparty.api.sms.api;

import cn.shishuihao.thirdparty.api.sms.SmsApi;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface SendBatchSmsApi extends SmsApi<SendBatchSmsApi, SendBatchSmsApiRequest, SendBatchSmsApiResponse> {
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
