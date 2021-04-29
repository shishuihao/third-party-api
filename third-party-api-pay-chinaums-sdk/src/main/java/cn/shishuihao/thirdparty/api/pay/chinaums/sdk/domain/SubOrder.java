package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@SuperBuilder
@Getter
public class SubOrder {
    /**
     * 子商户号 字符串 8..32 否.
     */
    @JsonProperty("mid")
    private final String mid;
    /**
     * 子商户分账金额 数字型 0..100000000 否.
     */
    @JsonProperty("totalAmount")
    private final Integer totalAmount;
    /**
     * 商户子订单号 字符串 6..32 否.
     */
    @JsonProperty("merOrderId")
    private final String merOrderId;
}
