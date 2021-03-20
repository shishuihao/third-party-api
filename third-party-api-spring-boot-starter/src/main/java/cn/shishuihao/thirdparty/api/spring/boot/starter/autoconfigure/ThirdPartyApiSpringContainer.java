package cn.shishuihao.thirdparty.api.spring.boot.starter.autoconfigure;

import cn.shishuihao.thirdparty.api.core.container.Container;
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

public class ThirdPartyApiSpringContainer
        implements Container, ApplicationContextAware {
    /**
     * applicationContext.
     */
    private static ApplicationContext applicationContext;
    /**
     * hooks.
     */
    private final List<Consumer<Container>> hooks = new ArrayList<>();

    /**
     * set ApplicationContext.
     *
     * @param context applicationContext
     * @throws BeansException BeansException
     */
    @Override
    public synchronized void setApplicationContext(
            @NonNull final ApplicationContext context) throws BeansException {
        ThirdPartyApiSpringContainer.applicationContext = context;
        Iterator<Consumer<Container>> it = this.hooks.iterator();
        while (it.hasNext()) {
            Consumer<Container> hook = it.next();
            hook.accept(this);
            it.remove();
        }
    }

    /**
     * aware or Hook.
     *
     * @param hook hook
     */
    @Override
    public void awareOrHook(final Consumer<Container> hook) {
        if (applicationContext != null) {
            hook.accept(this);
        } else {
            this.hooks.add(hook);
        }
    }

    /**
     * Return the bean instance that uniquely matches the given object type,
     * if any.
     *
     * @param requiredType type the bean must match;
     *                     can be an interface or superclass
     * @param <T>          requiredType
     * @return an instance of the single bean matching the required type
     */
    @Override
    public <T> T getBean(final Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    /**
     * Return the bean instances that match the given object type
     * (including subclasses).
     *
     * @param type the class or interface to match,
     *             or {@code null} for all concrete beans
     * @param <T>  requiredType
     * @return a Map with the matching beans, containing the bean names as
     * keys and the corresponding bean instances as values
     */
    @Override
    public <T> Map<String, T> getBeansOfType(final Class<T> type) {
        return applicationContext.getBeansOfType(type);
    }
}
