package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure;

import cn.shishuihao.thirdparty.api.core.EventPublisher;
import org.springframework.context.ApplicationContext;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ThirdPartyApiSpringEventPublisher implements EventPublisher {
    private final ApplicationContext applicationContext;

    public ThirdPartyApiSpringEventPublisher(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void publishEvent(Object event) {
        applicationContext.publishEvent(event);
    }
}
