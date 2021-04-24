package cn.shishuihao.thirdparty.api.pay.wechat.sdk.codec;

import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.AbstractWechatPayXmlResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.util.XmlUtils;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

import static java.lang.String.format;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Slf4j
public class WechatXmlDecoder extends Decoder.Default {
    /**
     * INSTANCE.
     */
    public static final WechatXmlDecoder INSTANCE = new WechatXmlDecoder();
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
                String xml = Util.toString(response.body().asReader());
                log.info("response body:{}", xml);
                return XmlUtils.fromXml(xml, (Class<?>) type);
            } catch (InstantiationException
                    | IllegalAccessException
                    | InvocationTargetException
                    | NoSuchMethodException e) {
                throw new DecodeException(format(FORMAT, type), e);
            }
        }
        return super.decode(response, type);
    }

    private boolean isAssignableFrom(final Class<?> type) {
        return AbstractWechatPayXmlResponse.class.isAssignableFrom(type);
    }
}
