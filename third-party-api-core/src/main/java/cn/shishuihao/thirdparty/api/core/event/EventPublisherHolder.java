package cn.shishuihao.thirdparty.api.core.event;

import cn.shishuihao.thirdparty.api.core.container.ContainerHolder;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public final class EventPublisherHolder {
    /**
     * event publisher.
     */
    public static final EventPublisher EVENT_PUBLISHER;

    static {
        EVENT_PUBLISHER = Optional.ofNullable(ContainerHolder.CONTAINER)
                .map(container -> container.getBean(EventPublisher.class))
                .orElseGet(() -> event -> {
                });
    }

    private EventPublisherHolder() {
    }

    /**
     * publish event.
     *
     * @param event event
     */
    public static void publishEvent(final Object event) {
        EVENT_PUBLISHER.publishEvent(event);
    }
}
