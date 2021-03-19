package cn.shishuihao.thirdparty.api.spring.boot.jpa.converter;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.repository.AggregateRootConverter;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.entity.ApiPropertiesJpaEntity;

import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiPropertiesJpaEntityConverter implements AggregateRootConverter<
        String,
        ApiProperties,
        ApiPropertiesJpaEntity> {
    /**
     * aggregate root to entity.
     *
     * @param aggregateRoot aggregate root
     * @return entity
     */
    @Override
    public ApiPropertiesJpaEntity convert(final ApiProperties aggregateRoot) {
        ApiPropertiesJpaEntity entity = new ApiPropertiesJpaEntity();
        entity.setChannelId(aggregateRoot.channelId());
        entity.setPropertiesId(aggregateRoot.id());
        entity.setProperties(aggregateRoot);
        entity.setGmtModified(LocalDateTime.now());
        return entity;
    }

    /**
     * aggregate root to entity.
     *
     * @param entity        entity
     * @param aggregateRoot aggregate root
     * @return entity
     */
    @Override
    public ApiPropertiesJpaEntity convert(final ApiPropertiesJpaEntity entity,
                                          final ApiProperties aggregateRoot) {
        entity.setProperties(aggregateRoot);
        entity.setGmtModified(LocalDateTime.now());
        return entity;
    }

    /**
     * entity to aggregate root.
     *
     * @param entity entity
     * @return aggregate root
     */
    @Override
    public ApiProperties convert(final ApiPropertiesJpaEntity entity) {
        return entity.getProperties();
    }
}
