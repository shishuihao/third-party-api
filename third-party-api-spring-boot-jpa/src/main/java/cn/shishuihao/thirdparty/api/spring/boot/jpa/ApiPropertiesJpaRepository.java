package cn.shishuihao.thirdparty.api.spring.boot.jpa;

import cn.shishuihao.thirdparty.api.core.ApiProperties;
import cn.shishuihao.thirdparty.api.core.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.entity.ApiPropertiesEntity;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.repository.ApiPropertiesEntityJpaRepository;
import org.springframework.cglib.beans.BeanMap;

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

    @SuppressWarnings("unchecked")
    @Override
    public void add(final ApiProperties apiProperties) {
        Optional<ApiPropertiesEntity> optional = jpaRepository.findByPropertiesId(apiProperties.id());
        ApiPropertiesEntity entity;
        if (optional.isPresent()) {
            entity = optional.get();
            entity.setProperties(BeanMap.create(apiProperties));
            entity.setGmtModified(LocalDateTime.now());
            jpaRepository.save(entity);
        } else {
            entity = ApiPropertiesEntity.from(apiProperties);
        }
        jpaRepository.save(entity);
    }

    @Override
    public Optional<ApiProperties> getById(final String id) {
        return jpaRepository.findByPropertiesId(id).map(ApiPropertiesEntity::toApiProperties);
    }

    @Override
    public Optional<ApiProperties> getApiProperties(final String channelId, final String propertiesId) {
        return jpaRepository.findByChannelIdAndPropertiesId(channelId, propertiesId).map(ApiPropertiesEntity::toApiProperties);
    }
}
