package cn.shishuihao.thirdparty.api.pay.weixin;

import cn.shishuihao.thirdparty.api.pay.properties.AbstractPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.SignType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(of = {
        "appId",
        "mchId",
        "subAppId",
        "subMchId"
}, callSuper = true)
@Getter
@Setter
public class WxPayApiProperties extends AbstractPayApiProperties {
    /**
     * 公众账号ID.
     * wx8888888888888888
     * 微信支付分配的公众账号ID（企业号corpid即为此appId）
     */
    private String appId;
    /**
     * 商户号.
     * 1900000109 微信支付分配的商户号
     */
    private String mchId;
    /**
     * 子商户应用ID.
     * wx8888888888888888 特约商户在微信开放平台上申请的APPID
     */
    private String subAppId;
    /**
     * 子商户号.
     * 1900000109 特约商户的商户号
     */
    private String subMchId;
    /**
     * 设备号.
     * 013467007045764 终端设备号(商户自定义，如门店编号)
     */
    private String deviceInfo;
    /**
     * 签名类型.
     * HMAC-SHA256
     * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
     */
    private SignType signType = SignType.MD5;
    /**
     * 商户密钥.
     */
    private String key;

    /**
     * new WxPayApiProperties.
     */
    public WxPayApiProperties() {
        this.setChannelId(WxPayApiChannel.CHANNEL_ID);
    }

    /**
     * get id.
     *
     * @return id
     */
    @Override
    public String id() {
        return String.join(":", String.valueOf(appId), String.valueOf(mchId),
                String.valueOf(subAppId), String.valueOf(subMchId));
    }
}
