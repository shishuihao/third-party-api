package cn.shishuihao.thirdparty.api.pay.weixin.sdk.codec;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.XmlUtils;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;

import static java.lang.String.format;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WxXmlDecoder implements Decoder {
    public static final WxXmlDecoder INSTANCE = new WxXmlDecoder();

    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {
        if (response.status() == HttpURLConnection.HTTP_NOT_FOUND) {
            return Util.emptyValueOf(type);
        }
        if (response.body() == null) {
            return null;
        }
        if (byte[].class.equals(type)) {
            return Util.toByteArray(response.body().asInputStream());
        }
        Response.Body body = response.body();
        if (String.class.equals(type)) {
            return Util.toString(body.asReader());
        }
        try {
            return XmlUtils.fromXml(Util.toString(body.asReader()), ((Class<?>) type));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new DecodeException(format("%s is not a type supported by this decoder.", type), e);
        }
    }
}
