package cn.shishuihao.thirdparty.api.pay.alipay.domain;

/**
 * @author admin
 * @version 1.0.0
 */

public enum RefundStatus {
    /**
     * 只在使用异步退款接口情况下才返回该字段。
     * 退款处理中；
     */
    REFUND_PROCESSING,
    /**
     * 退款处理成功；
     */
    REFUND_SUCCESS,
    /**
     * 退款失败;
     */
    REFUND_FAIL;
}
