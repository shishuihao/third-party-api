package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.SignType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@SuperBuilder
public abstract class AbstractWxPayXmlRequest {
    /**
     * 公众账号ID.
     * wx8888888888888888 微信支付分配的公众账号ID（企业号corpid即为此appId）
     */
    @XStreamAlias("appid")
    private final String appId;
    /**
     * 商户号.
     * 1900000109 微信支付分配的商户号
     */
    @XStreamAlias("mch_id")
    private final String mchId;
    /**
     * 子商户应用ID.
     * wx8888888888888888 特约商户在微信开放平台上申请的APPID
     */
    @XStreamAlias("sub_appid")
    private final String subAppId;
    /**
     * 子商户号.
     * 1900000109 特约商户的商户号
     */
    @XStreamAlias("sub_mch_id")
    private final String subMchId;
    /**
     * 设备号.
     * 013467007045764 终端设备号(商户自定义，如门店编号)
     */
    @XStreamAlias("device_info")
    private final String deviceInfo;
    /**
     * 随机字符串.
     * 5K8264ILTKCH16CQ2502SI8ZNMTM67VS 随机字符串，不长于32位。推荐随机数生成算法
     */
    @XStreamAlias("nonce_str")
    private final String nonceStr;
    /**
     * 签名类型.
     * HMAC-SHA256
     * 签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
     */
    @XStreamConverter(EnumToStringConverter.class)
    @XStreamAlias("sign_type")
    private final SignType signType;
    /**
     * 签名.
     * HMAC-C380BEC2BFD727A4B6845133519F3AD6 签名，详见签名生成算法
     */
    @XStreamAlias("sign")
    private String sign;
}
