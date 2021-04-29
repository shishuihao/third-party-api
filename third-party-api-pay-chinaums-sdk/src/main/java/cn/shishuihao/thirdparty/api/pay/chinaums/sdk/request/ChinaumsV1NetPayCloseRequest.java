package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * 订单关闭.
 * 用户创建订单之后，对未支付的订单进行关闭操作
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@SuperBuilder
@Getter
public class ChinaumsV1NetPayCloseRequest
        extends AbstractChinaumsRequest {
    /**
     * 商户订单号 字符串 6..64 是 原交易订单号.
     */
    @JsonProperty("merOrderId")
    private final String merOrderId;
}
