package cn.shishuihao.thirdparty.api.spring.boot.jpa;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.entity.ApiPropertiesJpaEntity;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.repository.ApiPropertiesEntityJpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiPropertiesJpaRepository implements ApiPropertiesRepository {
    private final ApiPropertiesEntityJpaRepository jpaRepository;

    public ApiPropertiesJpaRepository(ApiPropertiesEntityJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void add(final ApiProperties apiProperties) {
        ApiPropertiesJpaEntity entity = jpaRepository.findByPropertiesId(apiProperties.id())
                .map(it -> {
                    it.setProperties(apiProperties);
                    it.setGmtModified(LocalDateTime.now());
                    return it;
                })
                .orElseGet(() -> ApiPropertiesJpaEntity.from(apiProperties));
        jpaRepository.save(entity);
    }

    @Override
    public Optional<ApiProperties> getById(final String id) {
        return jpaRepository.findByPropertiesId(id)
                .map(ApiPropertiesJpaEntity::getProperties);
    }

    @Override
    public Optional<ApiProperties> getApiProperties(final String channelId, final String propertiesId) {
        return jpaRepository.findByChannelIdAndPropertiesId(channelId, propertiesId)
                .map(ApiPropertiesJpaEntity::getProperties);
    }
}
