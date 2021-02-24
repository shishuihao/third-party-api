package cn.shishuihao.thirdparty.api.sms.api;

import cn.shishuihao.thirdparty.api.sms.SmsApi;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface SendSmsApi extends SmsApi<SendSmsApi, SendSmsApiRequest, SendSmsApiResponse> {
    /**
     * get api type
     * immutable
     *
     * @return api type
     */
    @Override
    default Class<SendSmsApi> apiType() {
        return SendSmsApi.class;
    }
}
