package cn.shishuihao.thirdparty.api.pay.sdk.request;

import cn.shishuihao.thirdparty.api.pay.sdk.domain.TotalAmount;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@SuperBuilder
@Getter
public class PayV1TransactionsPlaceRequest
        extends AbstractPayV1Request {
    /**
     * 应用ID.
     */
    private final String appId;
    /**
     * 商品描述.
     */
    private final String description;
    /**
     * 商户订单号.
     */
    private final String outTradeNo;
    /**
     * 通知地址.
     */
    private final String notifyUrl;
    /**
     * 金额信息.
     */
    private final TotalAmount amount;
}
