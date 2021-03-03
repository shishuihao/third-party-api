package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.SignType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_10&index=1"}
 *
 * @author shishuihao
 * @version 1.0.0
 */
@XStreamAlias("xml")
public class WxPayOrderQueryRequest extends AbstractWxPayXmlRequest {
    /**
     * 微信订单号
     * String(32)
     * 1009660380201506130728806387
     * 微信的订单号，建议优先使用
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。详见商户订单号
     */
    @XStreamAlias("transaction_id")
    private final String transactionId;
    /**
     * 商户订单号	out_trade_no
     * String(32)
     * 20150806125346
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。 详见商户订单号
     */
    @XStreamAlias("out_trade_no")
    private final String outTradeNo;

    protected WxPayOrderQueryRequest(String appId, String mchId,
                                     String subAppId, String subMchId,
                                     String deviceInfo, String nonceStr,
                                     String sign, SignType signType,
                                     String transactionId, String outTradeNo) {
        super(appId, mchId, subAppId, subMchId, deviceInfo, nonceStr, sign, signType);
        this.transactionId = transactionId;
        this.outTradeNo = outTradeNo;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public static final class Builder {
        private String appId;
        private String mchId;
        private String subAppId;
        private String subMchId;
        private String deviceInfo;
        private String nonceStr;
        private String sign;
        private SignType signType;
        private String transactionId;
        private String outTradeNo;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public Builder mchId(String mchId) {
            this.mchId = mchId;
            return this;
        }

        public Builder subAppId(String subAppId) {
            this.subAppId = subAppId;
            return this;
        }

        public Builder subMchId(String subMchId) {
            this.subMchId = subMchId;
            return this;
        }

        public Builder deviceInfo(String deviceInfo) {
            this.deviceInfo = deviceInfo;
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

        public Builder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
            return this;
        }

        public WxPayOrderQueryRequest build() {
            return new WxPayOrderQueryRequest(appId, mchId, subAppId, subMchId, deviceInfo, nonceStr, sign, signType, transactionId, outTradeNo);
        }
    }
}
