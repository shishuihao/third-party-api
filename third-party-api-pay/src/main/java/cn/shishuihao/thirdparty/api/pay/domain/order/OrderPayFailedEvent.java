package cn.shishuihao.thirdparty.api.pay.domain.order;

import cn.shishuihao.thirdparty.api.core.event.DomainEvent;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class OrderPayFailedEvent extends DomainEvent {
    /**
     * new OrderPayFailedEvent.
     *
     * @param orderId order id.
     */
    public OrderPayFailedEvent(final String orderId) {
        super(orderId);
    }
}
