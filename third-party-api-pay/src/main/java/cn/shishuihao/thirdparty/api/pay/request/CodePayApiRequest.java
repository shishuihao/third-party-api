package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.CodePayApi;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CodePayApiRequest
        extends AbstractRequest<
        CodePayApi, CodePayApiRequest, CodePayApiResponse>
        implements PayApiRequest<
        CodePayApi, CodePayApiRequest, CodePayApiResponse> {
    /**
     * subject.
     */
    private final String subject;
    /**
     * out trade no.
     */
    private final String outTradeNo;
    /**
     * pay total amount.
     */
    private final int totalAmount;
    /**
     * auth code.such as qrcode.
     */
    private final String authCode;

    protected CodePayApiRequest(final String channelId,
                                final String propertiesId,
                                final String pSubject,
                                final String pOutTradeNo,
                                final int pTotalAmount,
                                final String pAuthCode) {
        super(channelId, propertiesId);
        this.subject = pSubject;
        this.outTradeNo = pOutTradeNo;
        this.totalAmount = pTotalAmount;
        this.authCode = pAuthCode;
    }

    /**
     * get subject.
     *
     * @return String
     */
    public String getSubject() {
        return subject;
    }

    /**
     * get outTradeNo.
     *
     * @return String
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * get totalAmount.
     *
     * @return String
     */
    public int getTotalAmount() {
        return totalAmount;
    }

    /**
     * get authCode.
     *
     * @return String
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    public Class<CodePayApi> apiType() {
        return CodePayApi.class;
    }

    /**
     * get response type.
     * immutable
     *
     * @return response type
     */
    @Override
    public Class<CodePayApiResponse> responseType() {
        return CodePayApiResponse.class;
    }


    public static final class Builder {
        /**
         * channel id.
         */
        private String channelId;
        /**
         * properties id.
         */
        private String propertiesId;
        /**
         * subject.
         */
        private String subject;
        /**
         * out trade no.
         */
        private String outTradeNo;
        /**
         * pay total amount.
         */
        private int totalAmount;
        /**
         * auth code.such as qrcode.
         */
        private String authCode;

        private Builder() {
        }

        /**
         * new Builder.
         *
         * @return Builder
         */
        public static Builder builder() {
            return new Builder();
        }

        /**
         * set channelId.
         *
         * @param pChannelId channelId
         * @return Builder
         */
        public Builder channelId(final String pChannelId) {
            this.channelId = pChannelId;
            return this;
        }

        /**
         * set propertiesId.
         *
         * @param pPropertiesId propertiesId
         * @return Builder
         */
        public Builder propertiesId(final String pPropertiesId) {
            this.propertiesId = pPropertiesId;
            return this;
        }

        /**
         * set subject.
         *
         * @param pSubject subject
         * @return Builder
         */
        public Builder subject(final String pSubject) {
            this.subject = pSubject;
            return this;
        }

        /**
         * set outTradeNo.
         *
         * @param pOutTradeNo outTradeNo
         * @return Builder
         */
        public Builder outTradeNo(final String pOutTradeNo) {
            this.outTradeNo = pOutTradeNo;
            return this;
        }

        /**
         * set totalAmount.
         *
         * @param pTotalAmount totalAmount
         * @return Builder
         */
        public Builder totalAmount(final int pTotalAmount) {
            this.totalAmount = pTotalAmount;
            return this;
        }

        /**
         * set authCode.
         *
         * @param pAuthCode authCode
         * @return Builder
         */
        public Builder authCode(final String pAuthCode) {
            this.authCode = pAuthCode;
            return this;
        }

        /**
         * build new CodePayApiRequest.
         *
         * @return CodePayApiRequest
         */
        public CodePayApiRequest build() {
            return new CodePayApiRequest(channelId, propertiesId,
                    subject, outTradeNo, totalAmount, authCode);
        }
    }
}
