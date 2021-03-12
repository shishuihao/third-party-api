package cn.shishuihao.thirdparty.api.tts;

import cn.shishuihao.thirdparty.api.core.request.ApiRequest;

/**
 * @param <A> tts api
 * @param <T> tts api request
 * @param <R> tts api response
 * @author shishuihao
 * @version 1.0.0
 */

public interface TtsApiRequest<
        A extends TtsApi<A, T, R>,
        T extends TtsApiRequest<A, T, R>,
        R extends TtsApiResponse>
        extends ApiRequest<A, T, R> {
}
