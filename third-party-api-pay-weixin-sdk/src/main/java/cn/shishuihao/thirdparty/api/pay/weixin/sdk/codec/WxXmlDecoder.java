package cn.shishuihao.thirdparty.api.pay.weixin.sdk.codec;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.response.AbstractWxPayXmlResponse;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.XmlUtils;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

import static java.lang.String.format;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WxXmlDecoder extends Decoder.Default {
    public static final WxXmlDecoder INSTANCE = new WxXmlDecoder();

    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {
        if (type instanceof Class<?> && AbstractWxPayXmlResponse.class.isAssignableFrom((Class<?>) type)) {
            try {
                String xml = Util.toString(response.body().asReader());
                return XmlUtils.fromXml(xml, (Class<?>) type);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new DecodeException(format("%s is not a type supported by this decoder.", type), e);
            }
        }
        return super.decode(response, type);
    }
}
