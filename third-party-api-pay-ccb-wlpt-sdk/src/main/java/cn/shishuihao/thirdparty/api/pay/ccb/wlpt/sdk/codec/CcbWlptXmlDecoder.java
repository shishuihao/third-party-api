package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.codec;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlptResponse;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;

import static java.lang.String.format;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Slf4j
public class CcbWlptXmlDecoder extends Decoder.Default {
    /**
     * INSTANCE.
     */
    public static final CcbWlptXmlDecoder INSTANCE = new CcbWlptXmlDecoder();
    /**
     * FORMAT.
     */
    public static final String FORMAT
            = "%s is not a type supported by this decoder.";

    private static String getResponseCharset(final String contentType) {
        String charset = "UTF-8";
        if (!StringUtils.isEmpty(contentType)) {
            String[] params = contentType.split(";");
            for (String param : params) {
                param = param.trim();
                if (param.startsWith("charset")) {
                    String[] pair = param.split("=", 2);
                    if (pair.length == 2) {
                        if (!StringUtils.isEmpty(pair[1])) {
                            charset = pair[1].trim();
                        }
                    }
                    break;
                }
            }
        }
        return charset;
    }

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
                String charset = Optional.ofNullable(response.headers())
                        .map(it -> it.get("content-type"))
                        .flatMap(it -> it.stream().findFirst())
                        .map(CcbWlptXmlDecoder::getResponseCharset)
                        .orElse("UTF-8");
                String xml = new String(Util.toByteArray(response.body()
                        .asInputStream()), charset);
                log.info("response body:{}", xml);
                return JacksonXmlUtils.fromXml(xml, (Class<?>) type);
            } catch (Exception e) {
                throw new DecodeException(format(FORMAT, type), e);
            }
        }
        return super.decode(response, type);
    }

    private boolean isAssignableFrom(final Class<?> type) {
        return CcbWlptResponse.class.isAssignableFrom(type);
    }
}
