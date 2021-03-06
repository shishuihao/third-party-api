package cn.shishuihao.thirdparty.api.core.event;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface EventPublisher {
    /**
     * publish event.
     *
     * @param event event
     */
    void publishEvent(Object event);
}
