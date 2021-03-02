package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.XmlUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public abstract class AbstractWxPayXmlRequest {
    /**
     * 公众账号ID wx8888888888888888 微信支付分配的公众账号ID（企业号corpid即为此appId）
     */
    @XStreamAlias("appid")
    private final String appId;
    /**
     * 商户号 1900000109 微信支付分配的商户号
     */
    @XStreamAlias("mch_id")
    private final String mchId;
    /**
     * 子商户应用ID wx8888888888888888 特约商户在微信开放平台上申请的APPID
     */
    @XStreamAlias("sub_appid")
    private final String subAppId;
    /**
     * 子商户号 1900000109 特约商户的商户号
     */
    @XStreamAlias("sub_mch_id")
    private final String subMchId;
    /**
     * 设备号 013467007045764 终端设备号(商户自定义，如门店编号)
     */
    @XStreamAlias("device_info")
    private final String deviceInfo;
    /**
     * 随机字符串 5K8264ILTKCH16CQ2502SI8ZNMTM67VS 随机字符串，不长于32位。推荐随机数生成算法
     */
    @XStreamAlias("nonce_str")
    private final String nonceStr;
    /**
     * 签名 HMAC-C380BEC2BFD727A4B6845133519F3AD6 签名，详见签名生成算法
     */
    @XStreamAlias("sign")
    private final String sign;
    /**
     * 签名类型 HMAC-SHA256
     * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
     */
    @XStreamAlias("sign_type")
    private final String signType;

    protected AbstractWxPayXmlRequest(String appId, String mchId,
                                      String subAppId, String subMchId,
                                      String deviceInfo, String nonceStr,
                                      String sign, String signType) {
        this.appId = appId;
        this.mchId = mchId;
        this.subAppId = subAppId;
        this.subMchId = subMchId;
        this.deviceInfo = deviceInfo;
        this.nonceStr = nonceStr;
        this.sign = sign;
        this.signType = signType;
    }

    public String getAppId() {
        return appId;
    }

    public String getMchId() {
        return mchId;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public String getSignType() {
        return signType;
    }

    public String toXml() {
        return XmlUtils.toXml(this);
    }
}
