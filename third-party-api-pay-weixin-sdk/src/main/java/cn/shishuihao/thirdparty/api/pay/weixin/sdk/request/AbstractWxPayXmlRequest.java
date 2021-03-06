package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.AppId;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.MchId;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.SignType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public abstract class AbstractWxPayXmlRequest {
    /**
     * 公众账号ID wx8888888888888888 微信支付分配的公众账号ID（企业号corpid即为此appId）
     */
    @XStreamAlias("appid")
    private AppId appId;
    /**
     * 商户号 1900000109 微信支付分配的商户号
     */
    @XStreamAlias("mch_id")
    private MchId mchId;
    /**
     * 子商户应用ID wx8888888888888888 特约商户在微信开放平台上申请的APPID
     */
    @XStreamAlias("sub_appid")
    private AppId subAppId;
    /**
     * 子商户号 1900000109 特约商户的商户号
     */
    @XStreamAlias("sub_mch_id")
    private MchId subMchId;
    /**
     * 设备号 013467007045764 终端设备号(商户自定义，如门店编号)
     */
    @XStreamAlias("device_info")
    private String deviceInfo;
    /**
     * 随机字符串 5K8264ILTKCH16CQ2502SI8ZNMTM67VS 随机字符串，不长于32位。推荐随机数生成算法
     */
    @XStreamAlias("nonce_str")
    private String nonceStr;
    /**
     * 签名 HMAC-C380BEC2BFD727A4B6845133519F3AD6 签名，详见签名生成算法
     */
    @XStreamAlias("sign")
    private String sign;
    /**
     * 签名类型 HMAC-SHA256
     * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
     */
    @XStreamConverter(EnumToStringConverter.class)
    @XStreamAlias("sign_type")
    private SignType signType;

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

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public SignType getSignType() {
        return signType;
    }

    public void setSignType(SignType signType) {
        this.signType = signType;
    }
}
