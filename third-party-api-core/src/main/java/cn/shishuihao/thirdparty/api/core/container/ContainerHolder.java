package cn.shishuihao.thirdparty.api.core.container;

import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public final class ContainerHolder {
    /**
     * container.
     */
    public static final Container CONTAINER;

    static {
        CONTAINER = StreamSupport.stream(ServiceLoader.load(Container.class)
                .spliterator(), false)
                .findFirst()
                .orElse(null);
    }

    private ContainerHolder() {
    }

    /**
     * get bean by required type.
     *
     * @param requiredType required type.
     * @param <T>          required type.
     * @return T
     */
    public static <T> T getBean(final Class<T> requiredType) {
        return CONTAINER.getBean(requiredType);
    }
}
