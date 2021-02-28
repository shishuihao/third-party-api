package cn.shishuihao.thirdparty.api.spring.boot.mongodb;

import cn.shishuihao.thirdparty.api.core.ApiProperties;
import cn.shishuihao.thirdparty.api.core.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.document.ApiPropertiesDocument;
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
        ApiPropertiesDocument entity = mongoRepository.findByPropertiesId(apiProperties.id())
                .map(it -> {
                    it.setProperties(apiProperties);
                    it.setGmtModified(LocalDateTime.now());
                    return it;
                })
                .orElseGet(() -> ApiPropertiesDocument.from(apiProperties));
        mongoRepository.save(entity);
    }

    @Override
    public Optional<ApiProperties> getById(final String id) {
        return mongoRepository.findByPropertiesId(id)
                .map(ApiPropertiesDocument::getProperties);
    }

    @Override
    public Optional<ApiProperties> getApiProperties(final String channelId, final String propertiesId) {
        return mongoRepository.findByChannelIdAndPropertiesId(channelId, propertiesId)
                .map(ApiPropertiesDocument::getProperties);
    }
}
