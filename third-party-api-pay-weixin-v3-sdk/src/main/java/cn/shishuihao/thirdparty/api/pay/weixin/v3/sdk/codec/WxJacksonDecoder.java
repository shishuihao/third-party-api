package cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk.codec;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk.domain.JsonSerializable;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Slf4j
public class WxJacksonDecoder extends Decoder.Default {
    /**
     * INSTANCE.
     */
    public static final WxJacksonDecoder INSTANCE = new WxJacksonDecoder();
    /**
     * FORMAT.
     */
    public static final String FORMAT
            = "%s is not a type supported by this decoder.";

    /**
     * decode response.
     *
     * @param response response
     * @param type     response type
     * @return response
     * @throws IOException    IOException
     * @throws FeignException FeignException
     */
    @Override
    public Object decode(final Response response,
                         final Type type) throws IOException, FeignException {
        if (type instanceof Class<?> && isAssignableFrom((Class<?>) type)) {
            String json = Util.toString(response.body().asReader());
            log.info("response body:{}", json);
            return JacksonUtils.fromJson(json, (Class<?>) type);
        }
        return super.decode(response, type);
    }

    private boolean isAssignableFrom(final Class<?> type) {
        return JsonSerializable.class.isAssignableFrom(type);
    }
}
