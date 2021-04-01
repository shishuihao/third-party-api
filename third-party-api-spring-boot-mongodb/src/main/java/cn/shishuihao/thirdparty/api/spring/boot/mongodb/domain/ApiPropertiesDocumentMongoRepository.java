package cn.shishuihao.thirdparty.api.spring.boot.mongodb.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Repository
public interface ApiPropertiesDocumentMongoRepository
        extends MongoRepository<ApiConfigurationMongodbDocument, Long> {
    /**
     * get api configuration.
     *
     * @param id configuration id
     * @return Optional<ApiConfigurationMongodbDocument>
     */
    Optional<ApiConfigurationMongodbDocument>
    findByConfigurationId(String id);

    /**
     * get api configuration.
     *
     * @param appId     app id
     * @param channelId channel id
     * @return Optional<ApiConfigurationMongodbDocument>
     */
    Optional<ApiConfigurationMongodbDocument>
    findByAppIdAndChannelId(String appId, String channelId);
}
