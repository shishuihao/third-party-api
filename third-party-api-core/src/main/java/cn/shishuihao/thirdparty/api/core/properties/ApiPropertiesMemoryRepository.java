package cn.shishuihao.thirdparty.api.core.properties;

import cn.shishuihao.thirdparty.api.core.repository.AbstractMemoryRepository;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApiPropertiesMemoryRepository extends AbstractMemoryRepository<String, ApiProperties> implements ApiPropertiesRepository {
    @Override
    public void add(ApiProperties entity) {
        map.put(getKey(entity.channelId(), entity.id()), entity);
        map.put(entity.id(), entity);
    }

    @Override
    public Optional<ApiProperties> getApiProperties(String channelId, String propertiesId) {
        return Optional.ofNullable(Optional.ofNullable(map.get(getKey(channelId, propertiesId)))
                .orElseGet(() -> map.get(propertiesId)));
    }

    private String getKey(String channelId, String propertiesId) {
        return channelId + '.' + propertiesId;
    }
}
