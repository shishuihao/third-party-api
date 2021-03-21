package cn.shishuihao.thirdparty.api.pay.domain.order;

import cn.shishuihao.thirdparty.api.core.event.DomainEvent;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class OrderPlacedEvent extends DomainEvent {
    /**
     * new OrderPlacedEvent.
     *
     * @param orderId order id.
     */
    public OrderPlacedEvent(final String orderId) {
        super(orderId);
    }
}
