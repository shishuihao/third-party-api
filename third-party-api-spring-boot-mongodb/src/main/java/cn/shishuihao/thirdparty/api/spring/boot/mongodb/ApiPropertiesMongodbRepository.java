package cn.shishuihao.thirdparty.api.spring.boot.mongodb;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.converter.ApiPropertiesMongodbDocumentConverter;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.document.ApiPropertiesMongodbDocument;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.repository.ApiPropertiesDocumentMongoRepository;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiPropertiesMongodbRepository
        extends AbstractMongoRepository<
        String,
        ApiProperties,
        ApiPropertiesMongodbDocument,
        ApiPropertiesDocumentMongoRepository>
        implements ApiPropertiesRepository {
    /**
     * new ApiPropertiesMongodbRepository.
     *
     * @param repository repository
     * @param converter  converter
     */
    public ApiPropertiesMongodbRepository(
            final ApiPropertiesDocumentMongoRepository repository,
            final ApiPropertiesMongodbDocumentConverter converter) {
        super(repository, converter);
    }

    /**
     * get entity by id.
     *
     * @param id id
     * @return option entity
     */
    @Override
    public Optional<ApiPropertiesMongodbDocument> findById(final String id) {
        return this.getMongoRepository()
                .findByPropertiesId(id);
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
        return this.getMongoRepository()
                .findByChannelIdAndPropertiesId(channelId, propertiesId)
                .map(ApiPropertiesMongodbDocument::getProperties);
    }
}
