package cn.shishuihao.thirdparty.api.pay.domain.order;

/**
 * order status.
 * place.
 *                  --> |place|PLACED
 * pay after PLACED or PAY_FAILED
 * PLACED           --> |pay|PAY_PROCESSED
 * PAY_FAILED       --> |pay|PAY_PROCESSED
 * PAY_PROCESSED    --> |pay query|PAY_SUCCEEDED
 * PAY_PROCESSED    --> |pay notify|PAY_SUCCEEDED
 * PAY_PROCESSED    --> |pay query|PAY_FAILED
 * PAY_PROCESSED    --> |pay notify|PAY_FAILED
 * cancel after PAY_PROCESSED or PAY_FAILED or CANCEL_FAILED
 * PAY_PROCESSED    --> |cancel|CANCEL_PROCESSED
 * PAY_FAILED       --> |cancel|CANCEL_PROCESSED
 * CANCEL_FAILED    --> |cancel|CANCEL_PROCESSED
 * CANCEL_PROCESSED --> |pay query|CANCEL_SUCCEEDED
 * CANCEL_PROCESSED --> |pay notify|CANCEL_SUCCEEDED
 * CANCEL_PROCESSED --> |pay query|CANCEL_FAILED
 * CANCEL_PROCESSED --> |pay notify|CANCEL_FAILED
 * refund after PAY_SUCCEEDED or REFUND_FAILED
 * PAY_SUCCEEDED    --> |refund|REFUND_PROCESSED
 * REFUND_FAILED    --> |refund|REFUND_PROCESSED
 * REFUND_PROCESSED --> |refund query|REFUND_SUCCEEDED
 * REFUND_PROCESSED --> |refund notify|REFUND_SUCCEEDED
 * REFUND_PROCESSED --> |refund query|REFUND_FAILED
 * REFUND_PROCESSED --> |refund notify|REFUND_FAILED
 * @author shishuihao
 * @version 1.0.0
 */

public enum OrderStatus {
    /**
     * order placed.
     */
    PLACED {
        @Override
        public boolean isPayable() {
            return true;
        }
    },
    /**
     * pay processed.
     */
    PAY_PROCESSED {
        @Override
        public boolean isCancelable() {
            return true;
        }
    },
    /**
     * pay succeeded.
     */
    PAY_SUCCEEDED {
        @Override
        public boolean isRefundable() {
            return true;
        }
    },
    /**
     * pay failed.
     */
    PAY_FAILED {
        @Override
        public boolean isPayable() {
            return true;
        }
        @Override
        public boolean isCancelable() {
            return true;
        }
    },
    /**
     * cancel processed.
     */
    CANCEL_PROCESSED,
    /**
     * cancel succeeded.
     */
    CANCEL_SUCCEEDED,
    /**
     * cancel failed.
     */
    CANCEL_FAILED {
        @Override
        public boolean isCancelable() {
            return true;
        }
    },
    /**
     * refund processed.
     */
    REFUND_PROCESSED,
    /**
     * refund succeeded.
     */
    REFUND_SUCCEEDED,
    /**
     * refund failed.
     */
    REFUND_FAILED {
        @Override
        public boolean isRefundable() {
            return true;
        }
    },;
    /**
     * able to pay.
     *
     * @return boolean
     */
    public boolean isPayable() {
        return false;
    }

    /**
     * able to cancel.
     *
     * @return boolean
     */
    public boolean isCancelable() {
        return false;
    }

    /**
     * able to refund.
     *
     * @return boolean
     */
    public boolean isRefundable() {
        return false;
    }
}
