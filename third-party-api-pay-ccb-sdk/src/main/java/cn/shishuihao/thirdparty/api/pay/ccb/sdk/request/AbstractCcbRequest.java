package cn.shishuihao.thirdparty.api.pay.ccb.sdk.request;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.CcbCryptorManager;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

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
public abstract class AbstractCcbRequest {
    /**
     * 商户号 15 Y.
     * 请联系开立商户的分行提供.
     * 105421097080009.
     */
    @JsonProperty("MERCHANTID")
    private final String merchantId;
    /**
     * 柜台号 9 Y.
     * 请联系开立商户的分行提供.
     * 902807340
     */
    @JsonProperty("POSID")
    private final String posId;
    /**
     * 分行号 9 Y.
     * 请联系开立商户的分行提供（一级分行号）.
     */
    @JsonProperty("BRANCHID")
    private final String branchId;
    /**
     * 集团商户信息 40 N （非集团商户无需上送）.
     * 集团主商户代理发起子商户交易时（验证主商户柜台公钥），需将集团主商户信息填入该字段，
     * 格式为：JTSH:主商户号+主商户柜台+主商户分行号
     * 例如：JTSH:105000000000000123456789441000000
     * 其中：
     * 105000000000000为主商户号，
     * 123456789为主商户柜台号，
     * 441000000 为主商户一级分行号.
     * JTSH:105000000000000123456789441000000
     */
    @JsonProperty("GROUPMCH")
    private final String groupMch;
    /**
     * 交易码 6 Y.
     */
    @JsonProperty("TXCODE")
    private final String txCode;
    /**
     * 商户类型 1 Y.
     * 1：线上商户
     * 2：线下商户
     * 商户类型请与分行确认.
     * 1
     */
    @JsonProperty("MERFLAG")
    private final Integer merchantFlag;
    /**
     * 终端编号1 19 N 商户类型为2时上送.
     * 请联系开立商户的分行提供
     * 1054210970800090001.
     */
    @JsonProperty("TERMNO1")
    private final String termNo1;
    /**
     * 终端编号 2 8 N 商户类型为2时上送.
     * 请联系开立商户的分行提供
     * 12345678.
     */
    @JsonProperty("TERMNO2")
    private final String termNo2;
    /**
     * 加密串 6144 Y.
     * 加密串通过[4.2.请求报文加密方法]中的说明生成，加密源串参数包含以下浅蓝色底纹的参数，如：
     * TXCODE=PAY100&MERFLAG=1&ORDERID=20180906101102
     * &QRCODE=134737690209713402&AMOUNT=0.01
     * 示例：
     * ylQZnF9G57gKymsjC99NTUyqUwynqgeCywvYhT%2FhW1%2CFRewTw4t0nEk8Jz%2FKYI%0AY6
     * Pa7rQPRMJ6nmkqO7B
     */
    @JsonIgnore
    private final Function<AbstractCcbRequest, String> queryString;

    /**
     * 加密串 6144 Y.
     * 加密串通过[4.2.请求报文加密方法]中的说明生成，加密源串参数包含以下浅蓝色底纹的参数，如：
     * TXCODE=PAY100&MERFLAG=1&ORDERID=20180906101102
     * &QRCODE=134737690209713402&AMOUNT=0.01
     * 示例：
     * ylQZnF9G57gKymsjC99NTUyqUwynqgeCywvYhT%2FhW1%2CFRewTw4t0nEk8Jz%2FKYI%0AY6
     * Pa7rQPRMJ6nmkqO7B
     *
     * @return String
     */
    @SuppressWarnings("unchecked")
    public String ccbParam() {
        final Map<String, Object> params = JacksonUtils
                .convert(this, LinkedHashMap.class);
        return params.entrySet().stream()
                .map(it -> it.getKey()
                        + "="
                        + Optional.ofNullable(it.getValue()).orElse(""))
                .collect(Collectors.joining("&"));
    }

    /**
     * 加密串 6144 Y.
     * 加密串通过[4.2.请求报文加密方法]中的说明生成，加密源串参数包含以下浅蓝色底纹的参数，如：
     * TXCODE=PAY100&MERFLAG=1&ORDERID=20180906101102
     * &QRCODE=134737690209713402&AMOUNT=0.01
     * 示例：
     * ylQZnF9G57gKymsjC99NTUyqUwynqgeCywvYhT%2FhW1%2CFRewTw4t0nEk8Jz%2FKYI%0AY6
     * Pa7rQPRMJ6nmkqO7B
     *
     * @param publicKey 公钥
     * @return String
     */
    public String ccbParam(final String publicKey) {
        return CcbCryptorManager.doEncrypt(publicKey, this.ccbParam());
    }

    /**
     * 获取查询字符串.
     *
     * @param publicKey 公钥
     * @return String
     */
    public String queryString(final String publicKey) {
        return "?MERCHANTID=" + merchantId
                + "&POSID=" + posId
                + "&BRANCHID=" + branchId
                + "&ccbParam=" + ccbParam(publicKey);
    }

    /**
     * 获取完整url.
     *
     * @param host      主机
     * @param publicKey 公钥
     * @return String
     */
    public String url(final String host, final String publicKey) {
        return host + queryString(publicKey);
    }
}
