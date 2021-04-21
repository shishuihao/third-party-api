package cn.shishuihao.thirdparty.api.commons.http.codec;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Slf4j
public class JacksonDecoder extends AbstractDecoder {
    /**
     * INSTANCE.
     */
    public static final JacksonDecoder INSTANCE = new JacksonDecoder();

    /**
     * to response from http response body.
     *
     * @param body http response body
     * @param type response type
     * @param <T>  response
     * @return response
     */
    @Override
    public <T> T fromBody(final String body, final Class<T> type) {
        return JacksonUtils.fromJson(body, type);
    }
}
