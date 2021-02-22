package cn.shishuihao.thirdparty.api.sms;

import cn.shishuihao.thirdparty.api.core.Request;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface SmsRequest<A extends SmsApi<A, T, R>, T extends SmsRequest<A, T, R>, R extends SmsResponse> extends Request<A, T, R> {
}
