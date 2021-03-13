package cn.shishuihao.thirdparty.api.face;

import cn.shishuihao.thirdparty.api.core.request.ApiRequest;

/**
 * @param <A> face api
 * @param <T> face api request
 * @param <R> face api response
 * @author shishuihao
 * @version 1.0.0
 */

public interface FaceApiRequest<
        A extends FaceApi<A, T, R>,
        T extends FaceApiRequest<A, T, R>,
        R extends FaceApiResponse>
        extends ApiRequest<A, T, R> {
}
