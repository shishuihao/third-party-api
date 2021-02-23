package cn.shishuihao.thirdparty.api.sms.api;

import cn.shishuihao.thirdparty.api.sms.SmsApi;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface SendSmsApi extends SmsApi<SendSmsApi, SendSmsRequest, SendSmsResponse> {
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
