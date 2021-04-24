package cn.shishuihao.thirdparty.api.pay.wechat.sdk.codec;

import cn.shishuihao.thirdparty.api.commons.http.codec.AbstractDecoder;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.util.XmlUtils;
import feign.codec.DecodeException;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;

import static java.lang.String.format;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Slf4j
public class WechatXmlDecoder extends AbstractDecoder {
    /**
     * INSTANCE.
     */
    public static final WechatXmlDecoder INSTANCE = new WechatXmlDecoder();

    /**
     * to response from http response body.
     *
     * @param body http response body
     * @param type response type
     * @param <T>  response
     * @return response
     * @throws DecodeException DecodeException
     */
    @Override
    public <T> T fromBody(final String body, final Class<T> type)
            throws DecodeException {
        try {
            return XmlUtils.fromXml(body, type);
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException
                | InstantiationException e) {
            throw new DecodeException(format(FORMAT, type), e);
        }
    }
}
