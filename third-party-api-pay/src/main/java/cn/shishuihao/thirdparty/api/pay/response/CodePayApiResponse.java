package cn.shishuihao.thirdparty.api.pay.response;

import cn.shishuihao.thirdparty.api.core.response.BaseApiResponse;
import cn.shishuihao.thirdparty.api.pay.PayApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CodePayApiResponse extends BaseApiResponse
        implements PayApiResponse {
    /**
     * new BaseApiResponse.
     *
     * @param pSuccess   is success
     * @param pCode      error code
     * @param pMessage   error message
     * @param pRequestId request id
     */
    protected CodePayApiResponse(final boolean pSuccess,
                                 final String pCode,
                                 final String pMessage,
                                 final String pRequestId) {
        super(pSuccess, pCode, pMessage, pRequestId);
    }

    public static final class Builder {
        /**
         * success.
         */
        private boolean success;
        /**
         * error code.
         */
        private String code;
        /**
         * error message.
         */
        private String message;
        /**
         * request id.
         */
        private String requestId;

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
         * set success.
         *
         * @param pSuccess success
         * @return Builder
         */
        public Builder success(final boolean pSuccess) {
            this.success = pSuccess;
            return this;
        }

        /**
         * set code.
         *
         * @param pCode code
         * @return Builder
         */
        public Builder code(final String pCode) {
            this.code = pCode;
            return this;
        }

        /**
         * set message.
         *
         * @param pMessage message
         * @return Builder
         */
        public Builder message(final String pMessage) {
            this.message = pMessage;
            return this;
        }

        /**
         * set requestId.
         *
         * @param pRequestId requestId
         * @return Builder
         */
        public Builder requestId(final String pRequestId) {
            this.requestId = pRequestId;
            return this;
        }

        /**
         * build new CodePayApiResponse.
         *
         * @return CodePayApiResponse
         */
        public CodePayApiResponse build() {
            return new CodePayApiResponse(success, code, message, requestId);
        }
    }
}
