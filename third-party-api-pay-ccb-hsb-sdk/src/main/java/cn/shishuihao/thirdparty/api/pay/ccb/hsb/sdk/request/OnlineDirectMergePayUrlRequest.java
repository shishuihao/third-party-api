package cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * 这个接口应用于无收银台支付场景，用于让客户刷新聚合二维码（聚合二维码的失效时间为15分钟）.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
public class OnlineDirectMergePayUrlRequest extends AbstractRequest {
    /**
     * 主订单编号.
     * VarChar2 40
     * 必输
     **/
    @JsonProperty("Main_Ordr_No")
    private final String mainOrderNo;
    /**
     * 支付流水号.
     * VarChar2	40
     * 必输
     **/
    @JsonProperty("Py_Trn_No")
    private final String payTransactionNo;
    /**
     * 支付方式代码.
     * VarChar2 2
     * 必输
     * 2-刷新聚合二维码
     **/
    @JsonProperty("Rqs_Py_Tp")
    private final String requestPayType;
    /**
     * 银行编码.
     * VarChar2 20
     * 非必输
     **/
    @JsonProperty("Bnk_Cd")
    private final String bankCode;
    /**
     * 分期期数.
     * VarChar2
     * 非必输
     **/
    @JsonProperty("Install_Num")
    private final String installNum;
}
