package cn.shishuihao.thirdparty.api.pay.domain.order;

/**
 * trade status.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public enum TradeStatus {
    /**
     * 新订单.
     */
    NEW_ORDER {
        @Override
        public boolean isPayable() {
            return true;
        }
    },
    /**
     * 交易创建，等待买家付款.
     */
    WAIT_BUYER_PAY {
        @Override
        public boolean isPayable() {
            return true;
        }

        @Override
        public boolean isCloseable() {
            return true;
        }

        @Override
        public boolean isCancelable() {
            return true;
        }
    },
    /**
     * 交易未知状态.
     */
    TRADE_UNKNOWN {
        @Override
        public boolean isCloseable() {
            return true;
        }

        @Override
        public boolean isCancelable() {
            return true;
        }
    },
    /**
     * 交易支付成功，可退款.
     */
    TRADE_SUCCESS {
        @Override
        public boolean isRefundable() {
            return true;
        }
    },
    /**
     * 交易支付失败.
     */
    TRADE_FAIL {
        @Override
        public boolean isPayable() {
            return true;
        }

        @Override
        public boolean isCloseable() {
            return true;
        }

        @Override
        public boolean isCancelable() {
            return true;
        }
    },
    /**
     * 转入退款.
     */
    TRADE_REFUND,
    /**
     * 交易已关闭.
     */
    TRADE_CLOSED,
    /**
     * 交易已完成.
     */
    TRADE_FINISHED;

    /**
     * able to pay.
     *
     * @return boolean
     */
    public boolean isPayable() {
        return false;
    }

    /**
     * able to close.
     * 交易关闭接口是用于交易状态处于WAIT_BUYER_PAY，客户在一定时间内未进行支付，对订单进行关闭。
     * 调用后交易状态
     * 调用交易关闭接口后，交易状态变为TRADE_CLOSE。
     * 调用时间限制
     * 交易关闭时间默认为15天，即交易创建后，如果用户一直未支付，系统15天后会自动结束该笔交易。
     *
     * @return boolean
     */
    public boolean isCloseable() {
        return false;
    }

    /**
     * able to cancel.
     * 适用于交易创建后，用户支付信息不确认，交易状态不明确，支付交易返回失败或支付系统超时，调用撤销交易。
     * 如果此订单用户支付失败，系统会将此订单关闭。
     * 如果用户支付成功，系统会将此订单资金退还给用户。
     * 注意：只有发生支付系统超时或者支付结果未知时可调用撤销，其他正常支付的单如需实现相同功能请调用申请退款API。
     * 提交支付交易后调用【查询订单API】，没有明确的支付结果再调用【撤销订单API】。
     * 调用后交易状态
     * 调用交易撤销接口后，交易状态变为TRADE_CLOSE。
     * 调用时间限制
     * 交易撤销接口限制时间为1天，即交易状态处于WAIT_BUYER_PAY的24小时内支持调用撤销接口，过了24小时，该接口无法再使用。
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
