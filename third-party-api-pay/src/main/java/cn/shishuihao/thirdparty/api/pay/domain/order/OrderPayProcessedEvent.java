package cn.shishuihao.thirdparty.api.pay.domain.order;

import cn.shishuihao.thirdparty.api.core.event.DomainEvent;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import lombok.Getter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
public class OrderPayProcessedEvent extends DomainEvent {
    /**
     * channel id.
     */
    private final String channelId;
    /**
     * properties id.
     */
    private final String propertiesId;
    /**
     * subject.
     */
    private final String subject;
    /**
     * total amount.
     */
    private final int totalAmount;
    /**
     * auth code.such as qrcode.
     */
    private final String authCode;

    /**
     * new OrderPayProcessedEvent.
     *
     * @param request request.
     */
    public OrderPayProcessedEvent(final CodePayApiRequest request) {
        super(request.getOutTradeNo());
        this.channelId = request.getChannelId();
        this.propertiesId = request.getPropertiesId();
        this.subject = request.getSubject();
        this.totalAmount = request.getTotalAmount();
        this.authCode = request.getAuthCode();
    }
}
