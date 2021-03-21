package cn.shishuihao.thirdparty.api.pay.domain.order;

import cn.shishuihao.thirdparty.api.core.event.DomainEvent;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class OrderPaySucceededEvent extends DomainEvent {
    /**
     * new OrderPaySucceededEvent.
     *
     * @param orderId order id.
     */
    public OrderPaySucceededEvent(final String orderId) {
        super(orderId);
    }
}
