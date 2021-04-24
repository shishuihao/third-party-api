package cn.shishuihao.thirdparty.api.pay.icbc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author admin
 * @version 1.0.0
 */
@Data
public class IcbcRefund {
    /**
     * str false 35 商户系统生成的退款编号.
     * X000000001
     */
    @JsonProperty("reject_no")
    private String rejectNo;
    /**
     * str false 30 行内生成的退款编号.
     * OFH20150812001668A0006501
     */
    @JsonProperty("icbc_reject_sq")
    private String icbcRejectSq;
    /**
     * str true 2 退款状态码.
     * 0：退款可疑
     * 1：退款成功
     * 2：退款失败
     * 1
     */
    @JsonProperty("reject_status")
    private String rejectStatus;
    /**
     * str false 17 实退金额(现金部分) 单位：分.
     * 100
     */
    @JsonProperty("real_reject_amt")
    private String realRejectAmt;
    /**
     * str false 17 本次退款总金额 其值=现金退款部分+积分，单位：分.
     * 100
     */
    @JsonProperty("reject_amt")
    private String rejectAmt;
    /**
     * str false 17 积分退款金额 单位：分.
     * 0
     */
    @JsonProperty("reject_point")
    private String rejectPoint;
    /**
     * str false 17 电子券退款金额 单位：分.
     * 0
     */
    @JsonProperty("reject_ecoupon")
    private String rejectEcoupon;
    /**
     * str false 19 屏蔽后的交易卡号.
     * 622208**6666
     */
    @JsonProperty("card_no")
    private String cardNo;
    /**
     * str false 32 本次所退优惠立减金额（商户部分），单位：分.
     * 0
     */
    @JsonProperty("reject_mer_disc_amt")
    private String rejectMerDiscAmt;
    /**
     * reject_bank_disc_amt str false 64 本次所退银行补贴金额，单位：分.
     * 0
     */
    @JsonProperty("reject_bank_disc_amt")
    private String rejectBankDiscAmt;
    /**
     * reject_total_disc_amt str false 64 本次所退总优惠金额.
     * 其值=本次所退优惠立减金额（商户部分）+本次所退银行补贴金额，单位：分 100
     */
    @JsonProperty("reject_total_disc_amt")
    private String rejectTotalDiscAmt;
}
