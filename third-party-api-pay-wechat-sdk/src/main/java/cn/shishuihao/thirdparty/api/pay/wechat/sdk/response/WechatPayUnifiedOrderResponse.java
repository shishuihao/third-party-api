package cn.shishuihao.thirdparty.api.pay.wechat.sdk.response;

import cn.shishuihao.thirdparty.api.pay.wechat.sdk.annotation.WechatParameter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
@XStreamAlias("xml")
public class WechatPayUnifiedOrderResponse
        extends AbstractWechatPayXmlResponse {
    /**
     * 交易类型.
     */
    @WechatParameter(
            name = "交易类型",
            required = true, type = "String(16)",
            example = "JSAPI",
            desc = "JSAPI 公众号支付\n"
                    + "NATIVE Native支付\n"
                    + "APP APP支付\n"
                    + "说明详见参数规定")
    @XStreamAlias("trade_type")
    private String tradeType;
    /**
     * 预支付交易会话标识.
     */
    @WechatParameter(
            name = "预支付交易会话标识",
            required = true, type = "String(64)",
            example = "wx201410272009395522657a690389285100",
            desc = "微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时")
    @XStreamAlias("prepay_id")
    private String prepayId;
    /**
     * 二维码链接.
     */
    @WechatParameter(
            name = "二维码链接",
            required = false, type = "String(64)",
            example = "weixin://wxpay/bizpayurl/up?pr=NwY5Mz9&groupid=00",
            desc = "trade_type=NATIVE时有返回，此url用于生成支付二维码，然后提供给用户进行扫码支付。\n"
                    + "注意：code_url的值并非固定，使用时按照URL格式转成二维码即可")
    @XStreamAlias("code_url")
    private String codeUrl;
}
