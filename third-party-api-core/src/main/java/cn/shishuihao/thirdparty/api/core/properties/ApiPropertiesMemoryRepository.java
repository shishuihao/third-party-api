package cn.shishuihao.thirdparty.api.core.properties;

import cn.shishuihao.thirdparty.api.core.repository.AbstractMemoryRepository;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApiPropertiesMemoryRepository
        extends AbstractMemoryRepository<String, ApiProperties>
        implements ApiPropertiesRepository {
    /**
     * new ApiPropertiesMemoryRepository.
     *
     * @param load whether load bean
     */
    public ApiPropertiesMemoryRepository(final boolean load) {
        if (load) {
            // spi => memory
            ServiceLoader.load(ApiProperties.class).forEach(this::add);
        }
    }

    /**
     * new ApiPropertiesMemoryRepository.
     */
    public ApiPropertiesMemoryRepository() {
        this(false);
    }

    /**
     * add api properties.
     *
     * @param entity entity
     */
    @Override
    public void add(final ApiProperties entity) {
        this.getMap().put(getKey(entity.channelId(), entity.id()), entity);
        this.getMap().put(entity.id(), entity);
    }

    /**
     * get api properties by channel id and properties id.
     *
     * @param channelId    channel id
     * @param propertiesId properties id
     * @return Optional<ApiProperties>
     */
    @Override
    public Optional<ApiProperties> getApiProperties(final String channelId,
                                                    final String propertiesId) {
        return Optional.ofNullable(Optional.ofNullable(this.getMap()
                .get(getKey(channelId, propertiesId)))
                .orElseGet(() -> this.getMap().get(propertiesId)));
    }

    private String getKey(final String channelId, final String propertiesId) {
        return channelId + '.' + propertiesId;
    }
}
