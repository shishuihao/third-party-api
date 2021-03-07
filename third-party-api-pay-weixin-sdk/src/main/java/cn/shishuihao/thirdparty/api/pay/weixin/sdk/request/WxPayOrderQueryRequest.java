package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
@XStreamAlias("xml")
public class WxPayOrderQueryRequest extends AbstractWxPayXmlRequest {
    /**
     * 微信订单号.
     * String(32)
     * 1009660380201506130728806387
     * 微信的订单号，建议优先使用
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。详见商户订单号
     */
    @XStreamAlias("transaction_id")
    private final String transactionId;
    /**
     * 商户订单号.
     * out_trade_no
     * String(32)
     * 20150806125346
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。 详见商户订单号
     */
    @XStreamAlias("out_trade_no")
    private final String outTradeNo;
}
