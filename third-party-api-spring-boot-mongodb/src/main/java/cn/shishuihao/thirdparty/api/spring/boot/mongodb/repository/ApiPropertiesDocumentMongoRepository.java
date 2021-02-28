package cn.shishuihao.thirdparty.api.spring.boot.mongodb.repository;

import cn.shishuihao.thirdparty.api.spring.boot.mongodb.document.ApiPropertiesDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Repository
public interface ApiPropertiesDocumentMongoRepository extends MongoRepository<ApiPropertiesDocument, Long> {
    /**
     * get by properties id
     *
     * @param id properties id
     * @return properties
     */
    Optional<ApiPropertiesDocument> findByPropertiesId(String id);

    /**
     * get by channel id and properties id
     *
     * @param channelId channel id
     * @param id        properties id
     * @return properties
     */
    Optional<ApiPropertiesDocument> findByChannelIdAndPropertiesId(String channelId, String id);
}
