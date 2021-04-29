package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request;

import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.domain.Good;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.domain.SubOrder;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * 异步分账确认.
 * 对于分账交易，用户支付成功后，在N天后需要对子订单信息进行修改确认，商户可调用此接口来进行异步分账确认操作。
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@SuperBuilder
@Getter
public class ChinaumsV1NetPaySubOrdersConfirmRequest
        extends AbstractChinaumsRequest {
    /**
     * 商户订单号 字符串 6..64 是 原交易订单号.
     */
    @JsonProperty("merOrderId")
    private final String merOrderId;
    /**
     * 平台商户退款分账金额 数字型 0..100000000 否.
     * 平台商户分账 金额,可以为 零.
     */
    @JsonProperty("platformAmount")
    private final Integer platformAmount;
    /**
     * 子订单信息 数组→JSON 否.
     * 异步分账确认 子订单信息.
     */
    @JsonProperty("subOrders")
    private final SubOrder[] subOrders;
    /**
     * 商品信息 数组→JSON 否.
     * 异步分账确认 商品信息
     */
    @JsonProperty("goods")
    private final Good[] goods;
}
