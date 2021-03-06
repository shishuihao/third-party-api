package cn.shishuihao.thirdparty.api.spring.boot.mongodb.repository;

import cn.shishuihao.thirdparty.api.spring.boot.mongodb.document.ApiPropertiesMongodbDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Repository
public interface ApiPropertiesDocumentMongoRepository extends MongoRepository<ApiPropertiesMongodbDocument, Long> {
    /**
     * get by properties id
     *
     * @param id properties id
     * @return properties
     */
    Optional<ApiPropertiesMongodbDocument> findByPropertiesId(String id);

    /**
     * get by channel id and properties id
     *
     * @param channelId channel id
     * @param id        properties id
     * @return properties
     */
    Optional<ApiPropertiesMongodbDocument> findByChannelIdAndPropertiesId(String channelId, String id);
}
