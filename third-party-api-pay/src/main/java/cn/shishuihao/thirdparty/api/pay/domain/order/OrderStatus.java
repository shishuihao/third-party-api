package cn.shishuihao.thirdparty.api.pay.domain.order;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public enum OrderStatus {
    /**
     * order created.
     * ==place==>   PLACED
     */
    PLACED,
    /**
     * pay processing.
     * PLACED     ==pay==>   PAY_PROCESSED
     * PAY_FAILED ==repay==> PAY_PROCESSED
     */
    PAY_PROCESSED,
    /**
     * pay succeeded.
     * PAY_PROCESSED ==query or notify==> PAY_SUCCEEDED
     */
    PAY_SUCCEEDED,
    /**
     * pay failed.
     * PAY_PROCESSED ==query or notify==>  PAY_FAILED
     */
    PAY_FAILED,
    ;
}
