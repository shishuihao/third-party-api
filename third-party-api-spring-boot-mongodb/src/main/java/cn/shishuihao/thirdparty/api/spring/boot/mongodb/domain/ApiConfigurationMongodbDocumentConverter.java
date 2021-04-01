package cn.shishuihao.thirdparty.api.spring.boot.mongodb.domain;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.repository.AggregateRootConverter;

import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiConfigurationMongodbDocumentConverter
        implements AggregateRootConverter<
        String,
        ApiConfiguration,
        ApiConfigurationMongodbDocument> {
    /**
     * aggregate root to document.
     *
     * @param aggregateRoot aggregate root
     * @return document
     */
    @Override
    public ApiConfigurationMongodbDocument convert(
            final ApiConfiguration aggregateRoot) {
        ApiConfigurationMongodbDocument document
                = new ApiConfigurationMongodbDocument();
        document.setAppId(aggregateRoot.getAppId());
        document.setChannelId(aggregateRoot.getChannelId());
        document.setConfigurationId(aggregateRoot.id());
        document.setProperties(aggregateRoot.getProperties());
        document.setGmtModified(LocalDateTime.now());
        return document;
    }

    /**
     * aggregate root to document.
     *
     * @param document      document
     * @param aggregateRoot aggregate root
     * @return document
     */
    @Override
    public ApiConfigurationMongodbDocument convert(
            final ApiConfigurationMongodbDocument document,
            final ApiConfiguration aggregateRoot) {
        document.setProperties(aggregateRoot.getProperties());
        document.setGmtModified(LocalDateTime.now());
        return document;
    }

    /**
     * document to aggregate root.
     *
     * @param document document
     * @return aggregate root
     */
    @Override
    public ApiConfiguration convert(
            final ApiConfigurationMongodbDocument document) {
        return ApiConfiguration.builder()
                .appId(document.getAppId())
                .channelId(document.getChannelId())
                .properties(document.getProperties())
                .build();
    }
}
