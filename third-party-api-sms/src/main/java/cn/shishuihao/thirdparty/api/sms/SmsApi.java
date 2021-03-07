package cn.shishuihao.thirdparty.api.sms;

import cn.shishuihao.thirdparty.api.core.api.Api;

/**
 * @param <A> sms api
 * @param <T> sms api request
 * @param <R> sms api response
 * @author shishuihao
 * @version 1.0.0
 */
public interface SmsApi<
        A extends SmsApi<A, T, R>,
        T extends SmsApiRequest<A, T, R>,
        R extends SmsApiResponse>
        extends Api<A, T, R> {
}
