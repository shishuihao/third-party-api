package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@Builder
@Getter
public class ReturnCommonParams {
    /**
     * 扫码点餐 字段 字符串 是 pre_order.
     */
    @JsonProperty("foodOrderType")
    private final String foodOrderType;
}
