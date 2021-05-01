package cn.shishuihao.thirdparty.api.pay.sdk.domain;

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
public class TotalAmount {
    /**
     * 金额.
     */
    private final String total;
    /**
     * 币种.
     */
    private final String currency;
}
