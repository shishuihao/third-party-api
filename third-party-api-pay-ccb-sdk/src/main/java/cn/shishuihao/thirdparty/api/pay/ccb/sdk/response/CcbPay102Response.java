package cn.shishuihao.thirdparty.api.pay.ccb.sdk.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ToString
@Getter
@Setter
public class CcbPay102Response extends AbstractCcbResponse {
    /**
     * 订单结果 1 Y.
     * Y：成功
     * N：失败
     * U：不确定（交易超时，建议再次查询）
     * Q：待查询（交易正在进行中，如等待客户付款）
     * Y
     */
    @JsonProperty("RESULT")
    private String result;
    /**
     * 订单号 30 N.
     * 从请求参数中获得
     * 20180906101102
     */
    @JsonProperty("ORDERID")
    private String orderId;
    /**
     * 订单金额 16 N.
     * 该笔订单的资金总额
     * 0.01
     */
    @JsonProperty("AMOUNT")
    private String amount;
    /**
     * 支付宝交易号 64 N.
     * 支付宝交易号
     * 2018090422001427221001018215
     */
    @JsonProperty("ZFB_NO")
    private String zfbNo;
    /**
     * 支付宝交易状态 32 N.
     * 交易状态：
     * WAIT_BUYER_PAY（交易创建，等待买家付款）
     * TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）
     * TRADE_SUCCESS（交易支付成功）
     * TRADE_FINISHED（交易结束，不可退款）
     * TRADE_SUCCESS
     */
    @JsonProperty("ZFB_STATE")
    private String zfbState;
    /**
     * 微信支付订单号32 N.
     * 微信支付订单号
     * 4200000160201809050255683083
     */
    @JsonProperty("WECHAT_NO")
    private String wechatNo;
    /**
     * 微信交易状态 32 N.
     * SUCCESS—支付成功
     * REFUND—转入退款
     * NOTPAY—未支付
     * CLOSED—已关闭
     * REVOKED—已撤销（刷卡支付）
     * USERPAYING--用户支付中
     * PAYERROR--支付失败（其他原因，如银行返回失败）
     * SUCCESS
     */
    @JsonProperty("WECHAT_STATE")
    private String wechatState;

    /**
     * 是否成功.
     *
     * @return boolean
     */
    @JsonIgnore
    @Override
    public boolean isSuccess() {
        return "Y".equalsIgnoreCase(result);
    }
}
