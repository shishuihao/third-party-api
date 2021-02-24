package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure;

import cn.shishuihao.thirdparty.api.core.Container;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ThirdPartyApiSpringContainer implements Container, ApplicationContextAware {
    private static ApplicationContext applicationContext;
    private final List<Consumer<Container>> hooks = new ArrayList<>();

    @Override
    public void setApplicationContext(@NonNull final ApplicationContext context) throws BeansException {
        ThirdPartyApiSpringContainer.applicationContext = context;
        Iterator<Consumer<Container>> it = this.hooks.iterator();
        while (it.hasNext()) {
            Consumer<Container> hook = it.next();
            hook.accept(this);
            it.remove();
        }
    }

    @Override
    public void awareOrHook(Consumer<Container> hook) {
        if (applicationContext != null) {
            hook.accept(this);
        } else {
            this.hooks.add(hook);
        }
    }

    @Override
    public <T> T getBean(Class<T> requiredType) {
        return ThirdPartyApiSpringContainer.applicationContext.getBean(requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> requiredType) {
        return ThirdPartyApiSpringContainer.applicationContext.getBeansOfType(requiredType);
    }
}
