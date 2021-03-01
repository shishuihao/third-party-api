package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.CodePayApi;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CodePayApiRequest extends AbstractRequest<CodePayApi, CodePayApiRequest, CodePayApiResponse>
        implements PayApiRequest<CodePayApi, CodePayApiRequest, CodePayApiResponse> {
    private final String subject;
    private final String outTradeNo;
    private final int totalAmount;
    private final String authCode;

    protected CodePayApiRequest(String channelId, String propertiesId,
                                String subject, String outTradeNo, int totalAmount, String authCode) {
        super(channelId, propertiesId);
        this.subject = subject;
        this.outTradeNo = outTradeNo;
        this.totalAmount = totalAmount;
        this.authCode = authCode;
    }

    public String getSubject() {
        return subject;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public String getAuthCode() {
        return authCode;
    }

    @Override
    public Class<CodePayApi> apiType() {
        return CodePayApi.class;
    }

    @Override
    public Class<CodePayApiResponse> responseType() {
        return CodePayApiResponse.class;
    }


    public static final class Builder {
        private String channelId;
        private String propertiesId;
        private String subject;
        private String outTradeNo;
        private int totalAmount;
        private String authCode;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder channelId(String channelId) {
            this.channelId = channelId;
            return this;
        }

        public Builder propertiesId(String propertiesId) {
            this.propertiesId = propertiesId;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder outTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
            return this;
        }

        public Builder totalAmount(int totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder authCode(String authCode) {
            this.authCode = authCode;
            return this;
        }

        public CodePayApiRequest build() {
            return new CodePayApiRequest(channelId, propertiesId, subject, outTradeNo, totalAmount, authCode);
        }
    }
}
