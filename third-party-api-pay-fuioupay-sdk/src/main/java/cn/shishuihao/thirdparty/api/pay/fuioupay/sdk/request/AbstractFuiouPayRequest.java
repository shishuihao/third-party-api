package cn.shishuihao.thirdparty.api.pay.fuioupay.sdk.request;

import cn.shishuihao.thirdparty.api.commons.http.util.QueryStringUtils;
import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ToString
@SuperBuilder
@Getter
public abstract class AbstractFuiouPayRequest {
    /**
     * 商户代码  15.
     * 富友分配给各合作商户的唯一识别码
     * 必填
     * 0002900F0006944
     */
    @JsonProperty("mchnt_cd")
    private final String merchantCode;

    /**
     * queryString.
     */
    @JsonIgnore
    private final Function<AbstractFuiouPayRequest, String> queryString;

    /**
     * 参数.
     *
     * @return String
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> params() {
        return JacksonUtils.convert(this, LinkedHashMap.class);
    }

    /**
     * 已编码参数.
     *
     * @param charset charset
     * @return String
     */
    public Map<String, String> encodedParams(final Charset charset) {
        return this.params().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        it -> Optional.ofNullable(it.getValue())
                                .map(Object::toString)
                                .map(value -> QueryStringUtils
                                        .encode(value, charset))
                                .orElse(""),
                        (u, v) -> u,
                        LinkedHashMap::new));
    }

    /**
     * 查询字符串.
     *
     * @param key 密钥
     * @return String
     */
    public String queryString(final String key) {
        final Map<String, String> params = this
                .encodedParams(StandardCharsets.UTF_8);
        final String qs = QueryStringUtils.toQueryString(params);
        final String md5Data = params.keySet().stream()
                .map(params::get)
                .collect(Collectors.joining("|", "", "|"))
                + key;
        final String md5 = DigestUtils.md5Hex(md5Data);
        return "md5=" + md5 + (StringUtils.isEmpty(qs)
                ? ""
                : "&" + qs);
    }
}
