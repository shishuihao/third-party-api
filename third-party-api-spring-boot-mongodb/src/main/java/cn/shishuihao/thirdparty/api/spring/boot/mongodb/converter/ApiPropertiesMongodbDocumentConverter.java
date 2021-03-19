package cn.shishuihao.thirdparty.api.spring.boot.mongodb.converter;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.repository.AggregateRootConverter;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.document.ApiPropertiesMongodbDocument;

import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiPropertiesMongodbDocumentConverter
        implements AggregateRootConverter<
        String,
        ApiProperties,
        ApiPropertiesMongodbDocument> {
    /**
     * aggregate root to document.
     *
     * @param aggregateRoot aggregate root
     * @return document
     */
    @Override
    public ApiPropertiesMongodbDocument convert(
            final ApiProperties aggregateRoot) {
        ApiPropertiesMongodbDocument document
                = new ApiPropertiesMongodbDocument();
        document.setChannelId(aggregateRoot.channelId());
        document.setPropertiesId(aggregateRoot.id());
        document.setProperties(aggregateRoot);
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
    public ApiPropertiesMongodbDocument convert(
            final ApiPropertiesMongodbDocument document,
            final ApiProperties aggregateRoot) {
        document.setProperties(aggregateRoot);
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
    public ApiProperties convert(final ApiPropertiesMongodbDocument document) {
        return document.getProperties();
    }
}
