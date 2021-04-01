package cn.shishuihao.thirdparty.api.core.configuration;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.repository.AbstractMemoryRepository;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApiConfigurationMemoryRepository
        extends AbstractMemoryRepository<String, ApiConfiguration>
        implements ApiConfigurationRepository {
    /**
     * new ApiConfigurationMemoryRepository.
     *
     * @param load whether load bean
     */
    public ApiConfigurationMemoryRepository(final boolean load) {
        if (load) {
            // spi => memory
            ServiceLoader.load(ApiProperties.class)
                    .forEach(properties -> this
                            .add(ApiConfiguration.builder()
                                    .appId(null)
                                    .channelId(properties.channelId())
                                    .properties(properties)
                                    .build()));
        }
    }

    /**
     * new ApiConfigurationMemoryRepository.
     */
    public ApiConfigurationMemoryRepository() {
        this(false);
    }

    /**
     * add api configuration.
     *
     * @param apiConfiguration api configuration
     */
    @Override
    public void add(final ApiConfiguration apiConfiguration) {
        String key = getKey(
                apiConfiguration.getAppId(),
                apiConfiguration.getChannelId());
        this.getMap().put(key, apiConfiguration);
        this.getMap().put(apiConfiguration.id(), apiConfiguration);
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
        return Optional.ofNullable(this.getMap()
                .get(getKey(appId, channelId)));
    }

    private String getKey(final String appId, final String channelId) {
        return appId + '.' + channelId;
    }
}
