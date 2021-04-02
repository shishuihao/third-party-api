package cn.shishuihao.thirdparty.api.core.configuration;

import cn.shishuihao.thirdparty.api.core.container.AbstractContainerRepository;
import cn.shishuihao.thirdparty.api.core.container.Container;
import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApiConfigurationContainerRepository
        extends AbstractContainerRepository<
        String, ApiConfiguration,
        ApiConfigurationRepository>
        implements ApiConfigurationRepository {

    /**
     * new ApiConfigurationContainerRepository.
     *
     * @param container container
     * @param load      whether load bean
     */
    public ApiConfigurationContainerRepository(final Container container,
                                               final boolean load) {
        super(container, ApiConfigurationRepository.class);
        if (load) {
            container.awareOrHook(it -> {
                // spi => container bean
                ServiceLoader.load(ApiProperties.class)
                        .forEach(properties -> this.getRepository()
                                .save(ApiConfiguration.builder()
                                        .appId(container.getApplicationId())
                                        .channelId(properties.channelId())
                                        .properties(properties)
                                        .build()));
                // container bean => container bean
                it.getBeansOfType(ApiProperties.class).values()
                        .forEach(properties -> this.getRepository()
                                .save(ApiConfiguration.builder()
                                        .appId(container.getApplicationId())
                                        .channelId(properties.channelId())
                                        .properties(properties)
                                        .build()));
            });
        }
    }

    /**
     * new ApiConfigurationContainerRepository.
     *
     * @param container container
     */
    public ApiConfigurationContainerRepository(final Container container) {
        this(container, false);
    }

    /**
     * get api configuration.
     *
     * @param appId     app id
     * @param channelId channel id
     * @return Optional<ApiConfiguration>
     */
    @Override
    public Optional<ApiConfiguration> getApiConfiguration(
            final String appId,
            final String channelId) {
        return this.getRepository().getApiConfiguration(appId, channelId);
    }
}
