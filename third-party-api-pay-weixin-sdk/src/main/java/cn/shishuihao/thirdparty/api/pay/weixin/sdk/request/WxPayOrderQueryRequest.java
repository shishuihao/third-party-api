package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.AppId;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.MchId;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.SignType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
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
    private String transactionId;
    /**
     * 商户订单号	out_trade_no
     * String(32)
     * 20150806125346
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。 详见商户订单号
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
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
        private String transactionId;
        private String outTradeNo;

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
            WxPayOrderQueryRequest wxPayOrderQueryRequest = new WxPayOrderQueryRequest();
            wxPayOrderQueryRequest.setAppId(appId);
            wxPayOrderQueryRequest.setMchId(mchId);
            wxPayOrderQueryRequest.setSubAppId(subAppId);
            wxPayOrderQueryRequest.setSubMchId(subMchId);
            wxPayOrderQueryRequest.setDeviceInfo(deviceInfo);
            wxPayOrderQueryRequest.setNonceStr(nonceStr);
            wxPayOrderQueryRequest.setSign(sign);
            wxPayOrderQueryRequest.setSignType(signType);
            wxPayOrderQueryRequest.setTransactionId(transactionId);
            wxPayOrderQueryRequest.setOutTradeNo(outTradeNo);
            return wxPayOrderQueryRequest;
        }
    }
}
