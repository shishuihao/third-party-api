package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * 担保撤销.
 * 对于担保交易（下单接口请求参数中上送了担保交易标识并置true），
 * 用户支付成功后，商户可调用此接口来进行担保撤销操作。。
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@SuperBuilder
@Getter
public class ChinaumsV1NetPaySecureCancelRequest
        extends AbstractChinaumsRequest {
    /**
     * 商户订单号 字符串 6..64 否.
     */
    @JsonProperty("merOrderId")
    private final String merOrderId;
}
