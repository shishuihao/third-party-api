package cn.shishuihao.thirdparty.api.pay.ccb.sdk.response;

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
public class CcbPay100Response extends AbstractCcbResponse {
    /**
     * 订单号 30 N.
     * 从请求参数中获得
     * 20180906101102
     */
    @JsonProperty("ORDERID")
    private String orderId;
    /**
     * 订单金额 16 N.
     * 从请求参数中获得
     * 5
     */
    @JsonProperty("AMOUNT")
    private String amount;
    /**
     * 二维码类型 1 N.
     * 1：龙支付
     * 2：微信
     * 3：支付宝
     * 4：银联
     * 2
     */
    @JsonProperty("QRCODETYPE")
    private String qrCodeType;
    /**
     * 等待时间 2 N.
     * RESULT为Q-待查询时返回，单位:秒.
     * 5
     */
    @JsonProperty("WAITTIME")
    private String waitTime;
}
