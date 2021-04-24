package cn.shishuihao.thirdparty.api.pay.ccb.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 支付宝/微信订单关闭-PAY103请求.
 * 如商户在轮询过程中，建行返回超时前结束轮询，且客户尚未完成付款，此时可调用此接口关闭订单。
 * 如客户已付款完成，则订单不允许关闭，请继续通过轮询或查询接口确认订单结果。暂仅支持支付宝和微信端的订单关闭。
 * 注意：按照[3.2.3.支付及轮询流程说明]中轮询机制处理的订单，建行会在超时前主动发起关闭，商户如无特殊轮询时间要求，建议不要主动调用此关闭接口。
 * 如特殊场景下商户需调用此关闭接口，请特别注意不要同时发起轮询订单（PAY101）接口和此关闭接口，
 * 商户发起轮询订单接口后，必须等待接口返回或超时之后方可发起此关闭接口。
 * 如不按规范调用，极有可能产生单边账务，需由商户自行承担。
 * 请求样例：（注意用 post 方式提交参数）
 * https://ibsbjstar.ccb.com.cn/CCBIS/B2CMainPlat_00_BEPAY
 * ?MERCHANTID=105421097080009
 * &POSID=902807340&BRANCHID=360000000
 * &ccbParam=ylQZnF9G57gKymsjC99NTUyqUwynqgeCywvYhT
 * %2FhW1%2CFRewTw4t0nEk8Jz%2FKYI%0AY6Pa7rQPRMJ6nmkqO7B
 * 备注说明：
 * 1、 当 PAY103 返回 N，且错误码为 9003 时，则代表建行此时未收到商户发起的 PAY100 扣款交易。
 * 商户需等待一段时间后，再次发起 PAY103，直到返回其他交易结果或达到超时时间，超时时间建议设置为 5 分钟。
 * 2、 当 PAY103 返回 N，且错误码为 9004 时，则代表建行此时已收到商户发起的 PAY100 扣款交易，客户扣款成功。
 * 若商户想撤销该笔订单，请先调用一笔 PAY101（因为可能出现客户输密的场景，必须先调用 PAY101 同步订单状态到建行），
 * 无论 PAY101 返回何种结果，再通过外联调用退款接口。
 *
 * @author shishuihao
 * @version 1.0.0
 */
@ToString
@SuperBuilder
@Getter
public class CcbPay103Request extends AbstractCcbRequest {
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
