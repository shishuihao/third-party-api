package cn.shishuihao.thirdparty.api.spring.boot.starter.autoconfigure;

import cn.shishuihao.thirdparty.api.core.event.EventPublisher;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.CompletableFuture;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class ThirdPartyApiSpringEventPublisher implements EventPublisher {
    /**
     * applicationContext.
     */
    private final ApplicationContext applicationContext;

    /**
     * publish event.
     *
     * @param event event
     */
    @Override
    public void publishEvent(final Object event) {
        CompletableFuture.runAsync(() ->
                applicationContext.publishEvent(event));
    }
}
