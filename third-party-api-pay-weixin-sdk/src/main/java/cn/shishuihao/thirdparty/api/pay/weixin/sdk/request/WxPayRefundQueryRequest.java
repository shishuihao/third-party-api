package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain.SignType;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@XStreamAlias("xml")
public class WxPayRefundQueryRequest extends AbstractWxPayXmlRequest {
    /**
     * 微信订单号 1217752501201407033233368018
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    @XStreamAlias("transaction_id")
    private final String transactionId;
    /**
     * 商户订单号 1217752501201407033233368018
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。详见商户订单号
     */
    @XStreamAlias("out_trade_no")
    private final String outTradeNo;
    /**
     * 商户退款单号 out_refund_no String(64) 1217752501201407033233368018
     * 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     */
    @XStreamAlias("out_refund_no")
    private final String outRefundNo;
    /**
     * 微信退款单号 refund_id String(32) 1217752501201407033233368018
     * 微信生成的退款单号，在申请退款接口有返回
     */
    @XStreamAlias("refund_id")
    private final String refundId;
    /**
     * 偏移量 offset 否 Int 15 偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录
     */
    @XStreamAlias("offset")
    private final Integer offset;

    protected WxPayRefundQueryRequest(String appId, String mchId,
                                      String subAppId, String subMchId,
                                      String deviceInfo, String nonceStr,
                                      String sign, SignType signType,
                                      String transactionId, String outTradeNo, String outRefundNo, String refundId,
                                      Integer offset) {
        super(appId, mchId, subAppId, subMchId, deviceInfo, nonceStr, sign, signType);
        this.transactionId = transactionId;
        this.outTradeNo = outTradeNo;
        this.outRefundNo = outRefundNo;
        this.refundId = refundId;
        this.offset = offset;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public String getRefundId() {
        return refundId;
    }

    public Integer getOffset() {
        return offset;
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
        private String outRefundNo;
        private String refundId;
        private Integer offset;

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

        public Builder outRefundNo(String outRefundNo) {
            this.outRefundNo = outRefundNo;
            return this;
        }

        public Builder refundId(String refundId) {
            this.refundId = refundId;
            return this;
        }

        public Builder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        public WxPayRefundQueryRequest build() {
            return new WxPayRefundQueryRequest(appId, mchId, subAppId, subMchId, deviceInfo, nonceStr, sign, signType, transactionId, outTradeNo, outRefundNo, refundId, offset);
        }
    }
}
