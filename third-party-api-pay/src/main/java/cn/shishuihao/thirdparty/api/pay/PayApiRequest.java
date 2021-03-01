package cn.shishuihao.thirdparty.api.pay;

import cn.shishuihao.thirdparty.api.core.ApiRequest;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface PayApiRequest<A extends PayApi<A, T, R>, T extends PayApiRequest<A, T, R>, R extends PayApiResponse> extends ApiRequest<A, T, R> {
}
