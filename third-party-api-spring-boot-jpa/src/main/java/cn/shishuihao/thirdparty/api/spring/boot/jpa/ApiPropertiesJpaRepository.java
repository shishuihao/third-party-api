package cn.shishuihao.thirdparty.api.spring.boot.jpa;

import cn.shishuihao.thirdparty.api.core.ApiProperties;
import cn.shishuihao.thirdparty.api.core.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.po.ApiPropertiesEntity;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.po.ApiPropertiesEntityJpaRepository;

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
    public void add(final ApiProperties entity) {
        jpaRepository.save(ApiPropertiesEntity.from(entity));
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
