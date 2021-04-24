package cn.shishuihao.thirdparty.api.commons.http.codec;

import cn.shishuihao.thirdparty.api.commons.http.response.HttpResponse;
import cn.shishuihao.thirdparty.api.commons.http.util.HeaderUtils;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;

import static java.lang.String.format;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Slf4j
public abstract class AbstractDecoder extends Decoder.Default {
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
        if (isResponseType((Class<?>) type)) {
            try {
                final String charset = HeaderUtils.getContentTypeCharset(
                        response, HeaderUtils.UTF_8);
                final String body = new String(Util.toByteArray(response.body()
                        .asInputStream()), charset);
                log.info("response body:{}", body);
                return fromBody(body, (Class<?>) type);
            } catch (DecodeException e) {
                throw e;
            } catch (Exception e) {
                throw new DecodeException(format(FORMAT, type), e);
            }
        }
        return super.decode(response, type);
    }

    /**
     * is response type.
     *
     * @param type response type
     * @return boolean
     */
    protected boolean isResponseType(final Class<?> type) {
        return type != null && HttpResponse.class.isAssignableFrom(type);
    }

    /**
     * to response from http response body.
     *
     * @param body http response body
     * @param type response type
     * @param <T>  response
     * @return response
     * @throws DecodeException DecodeException
     */
    public abstract <T> T fromBody(String body, Class<T> type)
            throws DecodeException;
}
