package cn.shishuihao.thirdparty.api.spring.boot.mongodb;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.converter.ApiConfigurationMongodbDocumentConverter;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.document.ApiConfigurationMongodbDocument;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.repository.ApiPropertiesDocumentMongoRepository;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiConfigurationMongodbRepository
        extends AbstractMongoRepository<
        String,
        ApiConfiguration,
        ApiConfigurationMongodbDocument,
        ApiPropertiesDocumentMongoRepository>
        implements ApiConfigurationRepository {
    /**
     * new ApiConfigurationMongodbRepository.
     *
     * @param repository repository
     * @param converter  converter
     */
    public ApiConfigurationMongodbRepository(
            final ApiPropertiesDocumentMongoRepository repository,
            final ApiConfigurationMongodbDocumentConverter converter) {
        super(repository, converter);
    }

    /**
     * get entity by id.
     *
     * @param id id
     * @return Optional<ApiConfigurationMongodbDocument>
     */
    @Override
    public Optional<ApiConfigurationMongodbDocument> findById(final String id) {
        return this.getMongoRepository()
                .findByConfigurationId(id);
    }

    /**
     * get api configuration.
     *
     * @param appId     app id
     * @param channelId channel id
     * @return Optional<ApiConfiguration>
     */
    @Override
    public Optional<ApiConfiguration> getApiConfiguration(
            final String appId,
            final String channelId) {
        return this.getMongoRepository()
                .findByAppIdAndChannelId(appId, channelId)
                .map(this.getConverter()::convert);
    }
}
