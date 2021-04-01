package cn.shishuihao.thirdparty.api.spring.boot.jpa.converter;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.repository.AggregateRootConverter;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.entity.ApiConfigurationJpaEntity;

import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiConfigurationJpaEntityConverter
        implements AggregateRootConverter<
        String,
        ApiConfiguration,
        ApiConfigurationJpaEntity> {
    /**
     * aggregate root to entity.
     *
     * @param aggregateRoot aggregate root
     * @return entity
     */
    @Override
    public ApiConfigurationJpaEntity convert(
            final ApiConfiguration aggregateRoot) {
        ApiConfigurationJpaEntity entity = new ApiConfigurationJpaEntity();
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
    public ApiConfigurationJpaEntity convert(
            final ApiConfigurationJpaEntity entity,
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
            final ApiConfigurationJpaEntity entity) {
        return ApiConfiguration.builder()
                .appId(entity.getAppId())
                .channelId(entity.getChannelId())
                .properties(entity.getProperties())
                .build();
    }
}
