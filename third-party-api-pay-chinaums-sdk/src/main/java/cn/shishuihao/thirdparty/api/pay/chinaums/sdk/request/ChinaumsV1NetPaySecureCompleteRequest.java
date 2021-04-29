package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * 担保完成.
 * 对于担保交易（下单接口请求参数中上送了担保交易标识并置true），
 * 用户支付成功后，商户可调用此接口来进行担保完成操作。
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@SuperBuilder
@Getter
public class ChinaumsV1NetPaySecureCompleteRequest
        extends AbstractChinaumsRequest {
    /**
     * 商户订单号 字符串 6..32 是 原交易订单号.
     */
    @JsonProperty("merOrderId")
    private final String merOrderId;
    /**
     * 担保完成金额 数字型 1..100000000 是.
     */
    @JsonProperty("completedAmount")
    private final Integer completedAmount;
}
