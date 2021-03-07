package cn.shishuihao.thirdparty.api.core.properties;

import cn.shishuihao.thirdparty.api.core.container.AbstractContainerRepository;
import cn.shishuihao.thirdparty.api.core.container.Container;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApiPropertiesContainerRepository
        extends AbstractContainerRepository<
        String, ApiProperties,
        ApiPropertiesRepository>
        implements ApiPropertiesRepository {

    /**
     * new ApiPropertiesContainerRepository.
     *
     * @param container container
     * @param load      whether load bean
     */
    public ApiPropertiesContainerRepository(final Container container,
                                            final boolean load) {
        super(container, ApiPropertiesRepository.class);
        if (load) {
            container.awareOrHook(it -> {
                // spi => container bean
                ServiceLoader.load(ApiProperties.class)
                        .forEach(this.getRepository()::add);
                // container bean => container bean
                it.getBeansOfType(ApiProperties.class).values()
                        .forEach(this.getRepository()::add);
            });
        }
    }

    /**
     * new ApiPropertiesContainerRepository.
     *
     * @param container container
     */
    public ApiPropertiesContainerRepository(final Container container) {
        this(container, false);
    }

    /**
     * get api properties.
     *
     * @param channelId    channel id
     * @param propertiesId properties id
     * @return Optional<ApiProperties>
     */
    @Override
    public Optional<ApiProperties> getApiProperties(final String channelId,
                                                    final String propertiesId) {
        return this.getRepository().getApiProperties(channelId, propertiesId);
    }
}
