package cn.shishuihao.thirdparty.api.spring.boot.mongodb;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.document.ApiPropertiesMongodbDocument;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.repository.ApiPropertiesDocumentMongoRepository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiPropertiesMongodbRepository implements ApiPropertiesRepository {
    private final ApiPropertiesDocumentMongoRepository mongoRepository;

    public ApiPropertiesMongodbRepository(ApiPropertiesDocumentMongoRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public void add(final ApiProperties apiProperties) {
        ApiPropertiesMongodbDocument entity = mongoRepository.findByPropertiesId(apiProperties.id())
                .map(it -> {
                    it.setProperties(apiProperties);
                    it.setGmtModified(LocalDateTime.now());
                    return it;
                })
                .orElseGet(() -> ApiPropertiesMongodbDocument.from(apiProperties));
        mongoRepository.save(entity);
    }

    @Override
    public Optional<ApiProperties> getById(final String id) {
        return mongoRepository.findByPropertiesId(id)
                .map(ApiPropertiesMongodbDocument::getProperties);
    }

    @Override
    public Optional<ApiProperties> getApiProperties(final String channelId, final String propertiesId) {
        return mongoRepository.findByChannelIdAndPropertiesId(channelId, propertiesId)
                .map(ApiPropertiesMongodbDocument::getProperties);
    }
}
