package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.converter;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.repository.AggregateRootConverter;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.entity.ApiPropertiesMybatisPlusEntity;

import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiPropertiesMybatisPlusEntityConverter
        implements AggregateRootConverter<
        String,
        ApiProperties,
        ApiPropertiesMybatisPlusEntity> {
    /**
     * aggregate root to entity.
     *
     * @param aggregateRoot aggregate root
     * @return entity
     */
    @Override
    public ApiPropertiesMybatisPlusEntity convert(
            final ApiProperties aggregateRoot) {
        ApiPropertiesMybatisPlusEntity entity
                = new ApiPropertiesMybatisPlusEntity();
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
    public ApiPropertiesMybatisPlusEntity convert(
            final ApiPropertiesMybatisPlusEntity entity,
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
    public ApiProperties convert(final ApiPropertiesMybatisPlusEntity entity) {
        return entity.getProperties();
    }
}
