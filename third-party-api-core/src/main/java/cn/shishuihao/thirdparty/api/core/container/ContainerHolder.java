package cn.shishuihao.thirdparty.api.core.container;

import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ContainerHolder {
    public static final Container CONTAINER;

    static {
        CONTAINER = StreamSupport.stream(ServiceLoader.load(Container.class).spliterator(), false)
                .findFirst()
                .orElse(null);
    }

    private ContainerHolder() {
    }

    public static <T> T getBean(Class<T> requiredType) {
        return CONTAINER.getBean(requiredType);
    }
}
