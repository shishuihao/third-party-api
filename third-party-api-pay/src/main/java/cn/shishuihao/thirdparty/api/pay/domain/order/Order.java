package cn.shishuihao.thirdparty.api.pay.domain.order;

import cn.shishuihao.thirdparty.api.core.repository.AggregateRoot;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
public class Order implements AggregateRoot<String> {
    // region place
    /**
     * order id.
     */
    private final String orderId;
    /**
     * order place time.
     */
    private final LocalDateTime placeTime;
    /**
     * order status.
     */
    private OrderStatus orderStatus = OrderStatus.PLACED;
    // endregion
    // region pay
    /**
     * order pay time.
     */
    private LocalDateTime payTime;
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
     * total amount.
     */
    private int totalAmount;
    /**
     * auth code.such as qrcode.
     */
    private String authCode;
    /**
     * order pay finish time.
     */
    private LocalDateTime payFinishTime;
    // endregion

    /**
     * place order.
     *
     * @param event event
     */
    public Order(final OrderPlacedEvent event) {
        this.orderId = event.getId();
        this.placeTime = event.getOccurred();
    }

    /**
     * handle pay event.
     *
     * @param event event
     */
    public void handle(final OrderPayProcessedEvent event) {
        this.orderStatus = OrderStatus.PAY_PROCESSED;
        this.payTime = event.getOccurred();
        this.channelId = event.getChannelId();
        this.propertiesId = event.getPropertiesId();
        this.subject = event.getSubject();
        this.totalAmount = event.getTotalAmount();
        this.authCode = event.getAuthCode();
    }

    /**
     * handle pay succeeded event.
     *
     * @param event event
     */
    public void handle(final OrderPaySucceededEvent event) {
        this.orderStatus = OrderStatus.PAY_SUCCEEDED;
        this.payFinishTime = event.getOccurred();
    }

    /**
     * handle pay failed event.
     *
     * @param event event
     */
    public void handle(final OrderPayFailedEvent event) {
        this.orderStatus = OrderStatus.PAY_FAILED;
        this.payFinishTime = event.getOccurred();
    }

    /**
     * get id.
     *
     * @return id
     */
    @Override
    public String id() {
        return orderId;
    }
}