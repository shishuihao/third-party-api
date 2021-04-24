package cn.shishuihao.thirdparty.api.pay.wechat.sdk.codec;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
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
public class WechatXmlEncoder implements Encoder {
    /**
     * INSTANCE.
     */
    public static final WechatXmlEncoder INSTANCE = new WechatXmlEncoder();

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
        String xml = JacksonXmlUtils.toXml(object);
        log.info("request body:{}", xml);
        template.body(xml);
    }
}
