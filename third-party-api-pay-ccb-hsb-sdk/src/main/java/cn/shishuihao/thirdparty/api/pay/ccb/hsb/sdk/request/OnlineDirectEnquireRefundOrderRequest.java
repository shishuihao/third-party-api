package cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * 这个接口用于让客户查询订单的退款结果，其使用规则与查询支付结果接口一致.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
public class OnlineDirectEnquireRefundOrderRequest extends AbstractRequest {
    /**
     * 客户方退款流水号.
     * VarChar2 40
     * 非必输
     * 客户方退款流水号与退款流水号必输其一
     */
    @JsonProperty("Cust_Rfnd_Trcno")
    private final String customerRefundTransactionNo;
    /**
     * 退款流水号.
     * VarChar2 40
     * 客户方退款流水号与退款流水号必输其一
     */
    @JsonProperty("Rfnd_Trcno")
    private final String refundTransactionNo;
}
