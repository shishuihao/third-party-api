package cn.shishuihao.thirdparty.api.pay.ccb.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 支付宝/微信订单查询-PAY102请求.
 * 如商户通过 PAY100 和 PAY101 接口仍无法确定当前订单状态，且商户使用场景需及时了解客户是否成功付款（商户入账结果可待后续调账），
 * 则可使用此接口查询该订单的客户付款结果，暂仅支持支付宝和微信。
 * 该接口仅作为订单查询的补充，商户可按需使用。
 * 请求样例：（注意用 post 方式提交参数）
 * https://ibsbjstar.ccb.com.cn/CCBIS/B2CMainPlat_00_BEPAY
 * ?MERCHANTID=105421097080009
 * &POSID=902807340&BRANCHID=360000000
 * &ccbParam=ylQZnF9G57gKymsjC99NTUyqUwynqgeCywvYhT
 * %2FhW1%2CFRewTw4t0nEk8Jz%2FKYI%0AY6Pa7rQPRMJ6nmkqO7B
 *
 * @author shishuihao
 * @version 1.0.0
 */
@ToString
@SuperBuilder
@Getter
public class CcbPay102Request extends AbstractCcbRequest {
    /**
     * 订单号 30 Y.
     * 订单标识，确保在商户系统中唯一
     * 20180906101102
     */
    @JsonProperty("ORDERID")
    private final String orderId;
    /**
     * 二维码类型 2 N.
     * 2：微信
     * 3：支付宝
     * 2
     */
    @JsonProperty("QRCODETYPE")
    private final String qrCodeType;
}
