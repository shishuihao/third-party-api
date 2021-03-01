package cn.shishuihao.thirdparty.api.push;

import cn.shishuihao.thirdparty.api.core.request.ApiRequest;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface PushApiRequest<A extends PushApi<A, T, R>, T extends PushApiRequest<A, T, R>, R extends PushApiResponse> extends ApiRequest<A, T, R> {
}
