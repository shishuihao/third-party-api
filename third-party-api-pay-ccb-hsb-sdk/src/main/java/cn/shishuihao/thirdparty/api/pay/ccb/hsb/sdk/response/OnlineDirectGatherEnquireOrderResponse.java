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
public class OnlineDirectGatherEnquireOrderResponse
        extends BaseCcbHsbPayResponse {
    /**
     * 主订单编号.
     * VarChar2 40
     * 必输
     */
    @JsonProperty("Main_Ordr_No")
    private String mainOrderNo;
    /**
     * 支付流水号.
     * VarChar2 40
     * 必输
     */
    @JsonProperty("Py_Trn_No")
    private String payTransactionNo;
    /**
     * 交易金额.
     * NUMBER 19,2
     * 必输
     **/
    @JsonProperty("Txnamt")
    private String transactionAmount;
    /**
     * 订单生成时间.
     * CHAR 14
     * 必输
     */
    @JsonProperty("Ordr_Gen_Tm")
    private String orderGenTime;
    /**
     * 订单超时时间.
     * CHAR 14
     * 必输
     */
    @JsonProperty("Ordr_Ovtm_Tm")
    private String orderOverTimeTime;
    /**
     * 订单状态代码.
     * VarChar2 2
     * 必输
     */
    @JsonProperty("Ordr_Stcd")
    private String orderStatusCode;
}
