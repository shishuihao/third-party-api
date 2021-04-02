package cn.shishuihao.thirdparty.api.core.channel;

import cn.shishuihao.thirdparty.api.core.container.AbstractContainerRepository;
import cn.shishuihao.thirdparty.api.core.container.Container;

import java.util.ServiceLoader;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApiChannelContainerRepository extends AbstractContainerRepository<
        String, ApiChannel<?>, ApiChannelRepository>
        implements ApiChannelRepository {
    /**
     * new ApiChannelContainerRepository.
     *
     * @param container container
     * @param load      whether load bean
     */
    public ApiChannelContainerRepository(final Container container,
                                         final boolean load) {
        super(container, ApiChannelRepository.class);
        if (load) {
            container.awareOrHook(it -> {
                // spi => container bean
                ServiceLoader.load(ApiChannel.class)
                        .forEach(this.getRepository()::save);
                // container bean => container bean
                it.getBeansOfType(ApiChannel.class).values()
                        .forEach(this.getRepository()::save);
            });
        }
    }

    /**
     * new ApiChannelContainerRepository.
     *
     * @param container container
     */
    public ApiChannelContainerRepository(final Container container) {
        this(container, false);
    }
}
