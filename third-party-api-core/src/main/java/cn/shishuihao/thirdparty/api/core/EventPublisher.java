package cn.shishuihao.thirdparty.api.core;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface EventPublisher {
    /**
     * push event
     *
     * @param event event
     */
    void publishEvent(Object event);
}
