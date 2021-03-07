package cn.shishuihao.thirdparty.api.spring.boot.mongodb;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.document.ApiPropertiesMongodbDocument;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.repository.ApiPropertiesDocumentMongoRepository;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class ApiPropertiesMongodbRepository implements ApiPropertiesRepository {
    /**
     * mongoRepository.
     */
    private final ApiPropertiesDocumentMongoRepository mongoRepository;

    /**
     * add apiProperties.
     *
     * @param apiProperties entity
     */
    @Override
    public void add(final ApiProperties apiProperties) {
        ApiPropertiesMongodbDocument entity = mongoRepository
                .findByPropertiesId(apiProperties.id())
                .map(it -> {
                    it.setProperties(apiProperties);
                    it.setGmtModified(LocalDateTime.now());
                    return it;
                })
                .orElseGet(() -> ApiPropertiesMongodbDocument
                        .from(apiProperties));
        mongoRepository.save(entity);
    }

    /**
     * get entity by id.
     *
     * @param id entity id
     * @return optional entity
     */
    @Override
    public Optional<ApiProperties> getById(final String id) {
        return mongoRepository.findByPropertiesId(id)
                .map(ApiPropertiesMongodbDocument::getProperties);
    }

    /**
     * get api properties by api type.
     *
     * @param channelId    channel id
     * @param propertiesId properties id
     * @return ApiProperties
     */
    @Override
    public Optional<ApiProperties> getApiProperties(final String channelId,
                                                    final String propertiesId) {
        return mongoRepository
                .findByChannelIdAndPropertiesId(channelId, propertiesId)
                .map(ApiPropertiesMongodbDocument::getProperties);
    }
}
