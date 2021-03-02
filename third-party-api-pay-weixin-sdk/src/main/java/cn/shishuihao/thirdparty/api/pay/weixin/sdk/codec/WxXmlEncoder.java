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
    public static final WxXmlEncoder INSTANCE = new WxXmlEncoder();

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        template.body(XmlUtils.toXml(object));
    }
}
