package cn.shishuihao.thirdparty.api.sms;

import cn.shishuihao.thirdparty.api.core.request.ApiRequest;

/**
 * @param <A> sms api
 * @param <T> sms api request
 * @param <R> sms api response
 * @author shishuihao
 * @version 1.0.0
 */

public interface SmsApiRequest<
        A extends SmsApi<A, T, R>,
        T extends SmsApiRequest<A, T, R>,
        R extends SmsApiResponse>
        extends ApiRequest<A, T, R> {
}
