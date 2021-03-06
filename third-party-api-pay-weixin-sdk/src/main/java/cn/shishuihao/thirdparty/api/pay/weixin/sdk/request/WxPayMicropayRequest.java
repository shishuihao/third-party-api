package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.AppId;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.MchId;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.SignType;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.XmlFieldUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@XStreamAlias("xml")
public class WxPayMicropayRequest extends AbstractWxPayXmlRequest {
    /**
     * 商品描述 image形象店-深圳腾大- QQ公仔 商品简单描述，该字段须严格按照规范传递，具体请见参数规定
     */
    @XStreamAlias("body")
    private final String body;
    /**
     * 商品详情 单品优惠功能字段，需要接入详见单品优惠详细说明
     */
    @XStreamAlias("detail")
    private final String detail;
    /**
     * 附加数据 附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
     */
    @XStreamAlias("attach")
    private final String attach;
    /**
     * 商户订单号 1217752501201407033233368018
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。详见商户订单号
     */
    @XStreamAlias("out_trade_no")
    private final String outTradeNo;
    /**
     * 订单金额 888 订单总金额，单位为分，只能为整数，详见支付金额
     */
    @XStreamAlias("total_fee")
    private final Integer totalFee;
    /**
     * 货币类型 CNY 符合ISO4217标准的三位字母代码，默认人民币：CNY，详见货币类型
     */
    @XStreamAlias("fee_type")
    private final String feeType;
    /**
     * 终端IP 8.8.8.8 支持IPV4和IPV6两种格式的IP地址。调用微信支付API的机器IP
     */
    @XStreamAlias("spbill_create_ip")
    private final String spBillCreateIp;
    /**
     * 订单优惠标记 1234 订单优惠标记，代金券或立减优惠功能的参数，详见代金券或立减优惠
     */
    @XStreamAlias("goods_tag")
    private final String goodsTag;
    /**
     * 指定支付方式 no_credit
     * no_credit--指定不能使用信用卡支付
     */
    @XStreamAlias("limit_pay")
    private final String limitPay;
    /**
     * 交易起始时间 20091225091010
     * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    @XStreamAlias("time_start")
    private final String timeStart;
    /**
     * 交易结束时间 20091227091010
     * 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。注意：最短失效时间间隔需大于1分钟
     */
    @XStreamAlias("time_expire")
    private final String timeExpire;
    /**
     * 电子发票入口开放标识 Y
     * Y，传入Y时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
     */
    @XStreamAlias("receipt")
    private final String receipt;
    /**
     * 付款码 auth_code 是 String(128) 120061098828009406
     * 扫码支付付款码，设备读取用户微信中的条码或者二维码信息
     * （注：用户付款码条形码规则：18位纯数字，以10、11、12、13、14、15开头）
     */
    @XStreamAlias("auth_code")
    private final String authCode;
    /**
     * 场景信息
     * {"store_info" : {
     * "id": "SZTX001",
     * "name": "腾大餐厅",
     * "area_code": "440305",
     * "address": "科技园中一路腾讯大厦" }}
     * 该字段常用于线下活动时的场景信息上报，支持上报实际门店信息，商户也可以按需求自己上报相关信息。
     * 该字段为JSON对象数据，对象格式为{"store_info":{"id": "门店ID","name": "名称","area_code": "编码","address": "地址" }} ，字段详细说明请点击行前的+展开
     */
    @XStreamAlias("scene_info")
    private final String sceneInfo;

    protected WxPayMicropayRequest(AppId appId, MchId mchId,
                                   AppId subAppId, MchId subMchId,
                                   String deviceInfo, String nonceStr,
                                   String sign, SignType signType,
                                   String body, String detail, String attach, String outTradeNo, Integer totalFee, String feeType, String spBillCreateIp, String goodsTag, String limitPay, String timeStart, String timeExpire, String authCode, String receipt, String sceneInfo) {
        super(appId, mchId, subAppId, subMchId, deviceInfo, nonceStr, sign, signType);
        this.body = body;
        this.detail = detail;
        this.attach = attach;
        this.outTradeNo = outTradeNo;
        this.totalFee = totalFee;
        this.feeType = feeType;
        this.spBillCreateIp = spBillCreateIp;
        this.goodsTag = goodsTag;
        this.limitPay = limitPay;
        this.timeStart = timeStart;
        this.timeExpire = timeExpire;
        this.authCode = authCode;
        this.receipt = receipt;
        this.sceneInfo = sceneInfo;
    }

    public String getBody() {
        return body;
    }

    public String getDetail() {
        return detail;
    }

    public String getAttach() {
        return attach;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public String getSpBillCreateIp() {
        return spBillCreateIp;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public String getAuthCode() {
        return authCode;
    }

    public String getReceipt() {
        return receipt;
    }

    public String getSceneInfo() {
        return sceneInfo;
    }

    public static final class Builder {
        private AppId appId;
        private MchId mchId;
        private AppId subAppId;
        private MchId subMchId;
        private String deviceInfo;
        private String nonceStr;
        private String sign;
        private SignType signType;
        private String body;
        private String detail;
        private String attach;
        private String outTradeNo;
        private Integer totalFee;
        private String feeType;
        private String spBillCreateIp;
        private String goodsTag;
        private String limitPay;
        private String timeStart;
        private String timeExpire;
        private String authCode;
        private String receipt;
        private String sceneInfo;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder appId(AppId appId) {
            this.appId = appId;
            return this;
        }

        public Builder mchId(MchId mchId) {
            this.mchId = mchId;
            return this;
        }

        public Builder subAppId(AppId subAppId) {
            this.subAppId = subAppId;
            return this;
        }

        public Builder subMchId(MchId subMchId) {
            this.subMchId = subMchId;
            return this;
        }

        public Builder nonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
            return this;
        }

        public Builder sign(String sign) {
            this.sign = sign;
            return this;
        }

        public Builder signType(SignType signType) {
            this.signType = signType;
            return this;
        }

        public Builder deviceInfo(String deviceInfo) {
            this.deviceInfo = deviceInfo;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder attach(String attach) {
            this.attach = attach;
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
            return this;
        }

        public Builder totalFee(Integer totalFee) {
            this.totalFee = totalFee;
            return this;
        }

        public Builder feeType(String feeType) {
            this.feeType = feeType;
            return this;
        }

        public Builder spBillCreateIp(String spBillCreateIp) {
            this.spBillCreateIp = spBillCreateIp;
            return this;
        }

        public Builder goodsTag(String goodsTag) {
            this.goodsTag = goodsTag;
            return this;
        }

        public Builder limitPay(String limitPay) {
            this.limitPay = limitPay;
            return this;
        }

        public Builder timeStart(String timeStart) {
            this.timeStart = timeStart;
            return this;
        }

        public Builder timeExpire(String timeExpire) {
            this.timeExpire = timeExpire;
            return this;
        }

        public Builder authCode(String authCode) {
            this.authCode = authCode;
            return this;
        }

        public Builder receipt(String receipt) {
            this.receipt = receipt;
            return this;
        }

        public Builder sceneInfo(String sceneInfo) {
            this.sceneInfo = sceneInfo;
            return this;
        }

        public WxPayMicropayRequest build(String signKey) throws UnsupportedEncodingException {
            Map<String, Object> params = XmlFieldUtils.getNameValueMap(this);
            return new WxPayMicropayRequest(appId, mchId, subAppId, subMchId, deviceInfo, nonceStr,
                    signType.sign(signKey, params), signType,
                    body, detail, attach, outTradeNo, totalFee, feeType, spBillCreateIp, goodsTag, limitPay, timeStart, timeExpire, authCode, receipt, sceneInfo);
        }

        public WxPayMicropayRequest build() {
            return new WxPayMicropayRequest(appId, mchId, subAppId, subMchId, deviceInfo, nonceStr,
                    sign, signType,
                    body, detail, attach, outTradeNo, totalFee, feeType, spBillCreateIp, goodsTag, limitPay, timeStart, timeExpire, authCode, receipt, sceneInfo);
        }
    }
}
