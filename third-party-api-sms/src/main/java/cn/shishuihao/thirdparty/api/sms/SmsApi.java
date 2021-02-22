package cn.shishuihao.thirdparty.api.sms;

import cn.shishuihao.thirdparty.api.core.Api;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface SmsApi<A extends SmsApi<A, T, R>, T extends SmsRequest<A, T, R>, R extends SmsResponse> extends Api<A, T, R> {
}
