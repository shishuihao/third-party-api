package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.converter;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.repository.AggregateRootConverter;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.entity.ApiConfigurationMybatisPlusEntity;

import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiConfigurationMybatisPlusEntityConverter
        implements AggregateRootConverter<
        String,
        ApiConfiguration,
        ApiConfigurationMybatisPlusEntity> {
    /**
     * aggregate root to entity.
     *
     * @param aggregateRoot aggregate root
     * @return entity
     */
    @Override
    public ApiConfigurationMybatisPlusEntity convert(
            final ApiConfiguration aggregateRoot) {
        ApiConfigurationMybatisPlusEntity entity
                = new ApiConfigurationMybatisPlusEntity();
        entity.setAppId(aggregateRoot.getAppId());
        entity.setChannelId(aggregateRoot.getChannelId());
        entity.setConfigurationId(aggregateRoot.id());
        entity.setProperties(aggregateRoot.getProperties());
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
    public ApiConfigurationMybatisPlusEntity convert(
            final ApiConfigurationMybatisPlusEntity entity,
            final ApiConfiguration aggregateRoot) {
        entity.setProperties(aggregateRoot.getProperties());
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
    public ApiConfiguration convert(
            final ApiConfigurationMybatisPlusEntity entity) {
        return ApiConfiguration.builder()
                .appId(entity.getAppId())
                .channelId(entity.getChannelId())
                .properties(entity.getProperties())
                .build();
    }
}
