package cn.shishuihao.thirdparty.api.pay.weixin;

import cn.shishuihao.thirdparty.api.core.properties.AbstractApiProperties;
import cn.shishuihao.thirdparty.api.pay.PayApiProperties;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.AppId;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.MchId;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.SignType;

import java.util.Objects;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WxPayApiProperties extends AbstractApiProperties implements PayApiProperties {
    /**
     * 公众账号ID wx8888888888888888 微信支付分配的公众账号ID（企业号corpid即为此appId）
     */
    private AppId appId;
    /**
     * 商户号 1900000109 微信支付分配的商户号
     */
    private MchId mchId;
    /**
     * 子商户应用ID wx8888888888888888 特约商户在微信开放平台上申请的APPID
     */
    private AppId subAppId;
    /**
     * 子商户号 1900000109 特约商户的商户号
     */
    private MchId subMchId;
    /**
     * 设备号 013467007045764 终端设备号(商户自定义，如门店编号)
     */
    private String deviceInfo;
    /**
     * 签名类型 HMAC-SHA256
     * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
     */
    private SignType signType = SignType.MD5;
    /**
     * 商户密钥
     */
    private String key;

    public WxPayApiProperties() {
        this.setChannelId(WxPayApiChannel.CHANNEL_ID);
    }

    @Override
    public String id() {
        return appId.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        WxPayApiProperties that = (WxPayApiProperties) o;
        return Objects.equals(appId, that.appId) && Objects.equals(mchId, that.mchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), appId, mchId);
    }

    public AppId getAppId() {
        return appId;
    }

    public void setAppId(AppId appId) {
        this.appId = appId;
    }

    public MchId getMchId() {
        return mchId;
    }

    public void setMchId(MchId mchId) {
        this.mchId = mchId;
    }

    public AppId getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(AppId subAppId) {
        this.subAppId = subAppId;
    }

    public MchId getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(MchId subMchId) {
        this.subMchId = subMchId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public SignType getSignType() {
        return signType;
    }

    public void setSignType(SignType signType) {
        this.signType = signType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
