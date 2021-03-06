package cn.shishuihao.thirdparty.api.core.container;

import cn.shishuihao.thirdparty.api.core.repository.Entity;

import java.util.Map;
import java.util.function.Consumer;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface Container extends Entity<String> {
    /**
     * get entity id.
     *
     * @return entity id
     */
    @Override
    default String id() {
        return this.getClass().getName();
    }

    /**
     * if {@code aware} apply hook else add hook.
     *
     * @param hook hook
     */
    void awareOrHook(Consumer<Container> hook);

    /**
     * Return the bean instance that uniquely matches the given object type,
     * if any.
     *
     * @param requiredType type the bean must match;
     *                     can be an interface or superclass
     * @param <T>          requiredType
     * @return an instance of the single bean matching the required type
     */
    <T> T getBean(Class<T> requiredType);

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
    <T> Map<String, T> getBeansOfType(Class<T> type);
}
