package cn.shishuihao.thirdparty.api.spring.boot.jpa.po;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Repository
public interface ApiPropertiesEntityJpaRepository extends JpaRepository<ApiPropertiesEntity, Long> {
    /**
     * get by properties id
     *
     * @param id properties id
     * @return properties
     */
    Optional<ApiPropertiesEntity> findByPropertiesId(String id);

    /**
     * get by channel id and properties id
     *
     * @param channelId channel id
     * @param id        properties id
     * @return properties
     */
    Optional<ApiPropertiesEntity> findByChannelIdAndPropertiesId(String channelId, String id);
}
