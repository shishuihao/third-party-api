package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.codec;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.util.TxXmlUtils;
import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Slf4j
public class CcbWlptXmlEncoder implements Encoder {
    /**
     * INSTANCE.
     */
    public static final CcbWlptXmlEncoder INSTANCE = new CcbWlptXmlEncoder();
    /**
     * INSTANCE.
     */
    public static final String PREFIX
            = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?>";

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
        final String xml = PREFIX + JacksonXmlUtils.toXml(object);
        final String txXml;
        try {
            txXml = TxXmlUtils.encode("txXml=" + xml);
        } catch (UnsupportedEncodingException e) {
            throw new EncodeException(e.getMessage(), e);
        }
        log.info("request body:{}", txXml);
        template.body(txXml);
    }
}
