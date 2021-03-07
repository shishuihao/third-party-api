package cn.shishuihao.thirdparty.api.pay.weixin.sdk.codec;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.XmlUtils;
import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;

import java.lang.reflect.Type;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WxXmlEncoder implements Encoder {
    /**
     * INSTANCE.
     */
    public static final WxXmlEncoder INSTANCE = new WxXmlEncoder();

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
        template.body(XmlUtils.toXml(object));
    }
}
