package cn.shishuihao.thirdparty.api.commons.http.codec;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Slf4j
public class JacksonEncoder implements Encoder {
    /**
     * INSTANCE.
     */
    public static final JacksonEncoder INSTANCE = new JacksonEncoder();

    /**
     * Converts objects to an appropriate representation
     * in the template.
     *
     * @param object   what to encode as the request body.
     * @param bodyType the type the object should be encoded as.
     *                 {@link #MAP_STRING_WILDCARD}indicates form encoding.
     * @param template the request template to populate.
     * @throws EncodeException when encoding failed due to a checked exception.
     */
    @Override
    public void encode(final Object object,
                       final Type bodyType,
                       final RequestTemplate template) throws EncodeException {
        final String json = JacksonUtils.toJson(object);
        log.info("request body:{}", json);
        template.body(json);
    }
}