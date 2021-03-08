package cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
public class OnlineDirectRefundOrderResponse
        extends BaseCcbHsbPayResponse {
    /**
     * 发起方流水号.
     * VarChar2 32
     * 必输
     * 该笔直连交易的客户方流水号（不允许重复）
     */
    @JsonProperty("Ittparty_Jrnl_No")
    private String ittPartyJrnlNo;
    /**
     * 客户方退款流水号.
     * VarChar2 40
     * 非必输
     */
    @JsonProperty("Cust_Rfnd_Trcno")
    private String customerRefundTransactionNo;
    /**
     * 退款流水号.
     * VarChar2 40
     * 必输
     */
    @JsonProperty("Rfnd_Trcno")
    private String refundTransactionNo;
    /**
     * 退款响应状态.
     * VarChar2 2
     * 必输
     * 00-退款成功
     * 01-退款失败
     * 02-退款延迟等待
     * 03-网银退款结果不确定（需人工处理）
     * 04-等待确认（线下订单类型返）
     */
    @JsonProperty("Refund_Rsp_St")
    private String refundResponseStatus;
    /**
     * 退款响应信息.
     * VarChar2 300
     * 非必输
     */
    @JsonProperty("Refund_Rsp_Inf")
    private String refundResponseInfo;
}
