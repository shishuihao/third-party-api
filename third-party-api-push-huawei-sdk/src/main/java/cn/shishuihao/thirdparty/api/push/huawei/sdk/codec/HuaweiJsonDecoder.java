package cn.shishuihao.thirdparty.api.push.huawei.sdk.codec;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.response.HuaweiPushResponse;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;

import static java.lang.String.format;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Slf4j
public class HuaweiJsonDecoder extends Decoder.Default {
    /**
     * INSTANCE.
     */
    public static final HuaweiJsonDecoder INSTANCE = new HuaweiJsonDecoder();
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
            try {
                String json = Util.toString(response.body().asReader());
                log.info("response body:{}", json);
                return JacksonUtils.fromJson(json, (Class<?>) type);
            } catch (Exception e) {
                throw new DecodeException(format(FORMAT, type), e);
            }
        }
        return super.decode(response, type);
    }

    private boolean isAssignableFrom(final Class<?> type) {
        return HuaweiPushResponse.class.isAssignableFrom(type);
    }
}
