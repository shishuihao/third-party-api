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
public class CcbPay107Response extends AbstractCcbResponse {
    /**
     * 订单结果 1 Y.
     * Y：成功
     * N：失败
     * Y
     */
    @JsonProperty("RESULT")
    private String result;
    /**
     * 用户标识 128 N.
     * 若上送的是微信付款码，则返回用户在建行appid下的唯一标识；
     * 若上送的是龙支付付款码，则返回龙支付客户id
     * wx51264215241265
     */
    @JsonProperty("OPENID")
    private String openId;
    /**
     * 用户子标识 128 N.
     * 微信支付专有字段。
     * 子商户appid下用户唯一标识，如需返回则请求时需要传sub_appid
     * oZQ9N5YdEISznlF0hk2vedjMBe9A
     */
    @JsonProperty("SUB_OPENID")
    private String subOpenId;
}
