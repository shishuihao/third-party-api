package cn.shishuihao.thirdparty.api.core.channel;

import cn.shishuihao.thirdparty.api.core.container.AbstractContainerRepository;
import cn.shishuihao.thirdparty.api.core.container.Container;

import java.util.ServiceLoader;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApiChannelContainerRepository extends AbstractContainerRepository<String, ApiChannel<?>, ApiChannelRepository>
        implements ApiChannelRepository {
    public ApiChannelContainerRepository(Container container, boolean load) {
        super(container, ApiChannelRepository.class);
        if (load) {
            container.awareOrHook(it -> {
                // spi => container bean
                ServiceLoader.load(ApiChannel.class).forEach(repository::add);
                // container bean => container bean
                it.getBeansOfType(ApiChannel.class).values().forEach(repository::add);
            });
        }
    }

    public ApiChannelContainerRepository(Container container) {
        this(container, false);
    }
}
