package cn.shishuihao.thirdparty.api.pay.fuioupay.sdk.codec;

import cn.shishuihao.thirdparty.api.pay.fuioupay.sdk.request.AbstractFuiouPayRequest;
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
public class FuiouXmlEncoder extends Encoder.Default {
    /**
     * INSTANCE.
     */
    public static final FuiouXmlEncoder INSTANCE = new FuiouXmlEncoder();

    /**
     * encode request.
     *
     * @param object   request
     * @param bodyType body type
     * @param template request template
     * @throws EncodeException EncodeException
     */
    @Override
    public void encode(final Object object,
                       final Type bodyType,
                       final RequestTemplate template) throws EncodeException {
        if (object instanceof AbstractFuiouPayRequest) {
            final AbstractFuiouPayRequest request
                    = ((AbstractFuiouPayRequest) object);
            final String queryString = request.getQueryString().apply(request);
            log.info("request queryString:{}", queryString);
            template.append(queryString);
        } else {
            super.encode(object, bodyType, template);
        }
    }
}
