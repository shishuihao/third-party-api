package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.annotation.WxParameter;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.SignType;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
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
     * 公众账号ID|APP ID|小程序ID.
     */
    @WxParameter(
            environment = "境内普通商户[付款码|JSAPI|Native|H5]", name = "公众账号ID",
            required = true, type = "String(32)",
            example = "wx8888888888888888",
            desc = "微信支付分配的公众账号ID（企业号corpid即为此appId）")
    @WxParameter(
            environment = "境内普通商户[APP]", name = "应用ID",
            required = true, type = "String(32)",
            example = "wxd678efh567hg6787",
            desc = "微信开放平台审核通过的应用APPID（请登录open.weixin.qq.com查看，注意与公众号的APPID不同）")
    @WxParameter(
            environment = "境内普通商户[小程序]", name = "小程序ID",
            required = true, type = "String(32)",
            example = "wxd678efh567hg6787",
            desc = "微信分配的小程序ID")
    @JacksonXmlProperty(localName = "appid")
    private final String appId;
    /**
     * 商户号.
     */
    @WxParameter(
            environment = "境内普通商户", name = "商户号",
            required = true, type = "String(32)",
            example = "1230000109",
            desc = "微信支付分配的商户号")
    @JacksonXmlProperty(localName = "mch_id")
    private final String mchId;
    /**
     * 子商户应用ID.
     */
    @WxParameter(
            environment = "境内服务商[付款码|JSAPI|Native|H5]", name = "子商户公众账号ID",
            required = false, type = "String(32)",
            example = "wx8888888888888888",
            desc = "微信分配的子商户公众账号ID，如需在支付完成后获取sub_openid则此参数必传。")
    @WxParameter(
            environment = "境内服务商[APP]", name = "子商户应用ID",
            required = false, type = "String(32)",
            example = "wx8888888888888888",
            desc = "特约商户在微信开放平台上申请的APPID")
    @WxParameter(
            environment = "境内服务商[小程序]", name = "子商户应用ID",
            required = false, type = "String(32)",
            example = "wx8888888888888888",
            desc = "特约商户的小程序ID")
    @JacksonXmlProperty(localName = "sub_appid")
    private final String subAppId;
    /**
     * 子商户号.
     */
    @WxParameter(
            environment = "境内服务商", name = "子商户号",
            required = true, type = "String(32)",
            example = "1900000109",
            desc = "微信支付分配的子商户号|特约商户的商户号")
    @JacksonXmlProperty(localName = "sub_mch_id")
    private final String subMchId;
    /**
     * 设备号.
     * 必填：否
     * String(32)
     * 013467007045764
     * 终端设备号(商户自定义，如门店编号)
     * APP支付下：终端设备号(门店号或收银设备ID)，默认请传"WEB"
     */
    @WxParameter(
            name = "设备号",
            required = false, type = "String(32)",
            example = "013467007045764",
            desc = "终端设备号(商户自定义，如门店编号)")
    @JacksonXmlProperty(localName = "device_info")
    private final String deviceInfo;
    /**
     * 随机字符串.
     */
    @WxParameter(
            name = "随机字符串",
            required = true, type = "String(32)",
            example = "5K8264ILTKCH16CQ2502SI8ZNMTM67VS",
            desc = "随机字符串，不长于32位。推荐随机数生成算法")
    @JacksonXmlProperty(localName = "nonce_str")
    private final String nonceStr;
    /**
     * 签名类型.
     */
    @WxParameter(
            name = "签名类型",
            required = false, type = "String(32)",
            example = "HMAC-SHA256",
            desc = "签名类型，目前支持HMAC-SHA256和MD5，默认为MD5")
    @XStreamConverter(EnumToStringConverter.class)
    @JacksonXmlProperty(localName = "sign_type")
    private final SignType signType;
    /**
     * 签名.
     */
    @WxParameter(
            name = "签名",
            required = true, type = "String(32)",
            example = "C380BEC2BFD727A4B6845133519F3AD6",
            desc = "签名，详见签名生成算法")
    @JacksonXmlProperty(localName = "sign")
    private String sign;
}
