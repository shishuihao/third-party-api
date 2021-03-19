package cn.shishuihao.thirdparty.api.spring.boot.jpa;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.entity.ApiPropertiesJpaEntity;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.repository.ApiPropertiesEntityJpaRepository;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class ApiPropertiesJpaRepository implements ApiPropertiesRepository {
    /**
     * jpaRepository.
     */
    private final ApiPropertiesEntityJpaRepository jpaRepository;

    /**
     * add api properties.
     *
     * @param apiProperties api properties
     */
    @Override
    public void add(final ApiProperties apiProperties) {
        ApiPropertiesJpaEntity entity = jpaRepository
                .findByPropertiesId(apiProperties.id())
                .map(it -> {
                    it.setProperties(apiProperties);
                    it.setGmtModified(LocalDateTime.now());
                    return it;
                })
                .orElseGet(() -> ApiPropertiesJpaEntity.from(apiProperties));
        jpaRepository.save(entity);
    }

    /**
     * get api properties by properties id.
     *
     * @param propertiesId api properties id
     * @return optional api properties
     */
    @Override
    public Optional<ApiProperties> get(final String propertiesId) {
        return jpaRepository
                .findByPropertiesId(propertiesId)
                .map(ApiPropertiesJpaEntity::getProperties);
    }

    /**
     * get api properties by channel id and properties id.
     *
     * @param channelId    channel id
     * @param propertiesId properties id
     * @return optional api properties
     */
    @Override
    public Optional<ApiProperties> getApiProperties(final String channelId,
                                                    final String propertiesId) {
        return jpaRepository
                .findByChannelIdAndPropertiesId(channelId, propertiesId)
                .map(ApiPropertiesJpaEntity::getProperties);
    }
}
