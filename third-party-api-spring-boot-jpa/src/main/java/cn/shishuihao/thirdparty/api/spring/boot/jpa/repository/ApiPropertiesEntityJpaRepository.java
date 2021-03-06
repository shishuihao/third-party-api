package cn.shishuihao.thirdparty.api.spring.boot.jpa.repository;

import cn.shishuihao.thirdparty.api.spring.boot.jpa.entity.ApiPropertiesJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Repository
public interface ApiPropertiesEntityJpaRepository extends JpaRepository<ApiPropertiesJpaEntity, Long> {
    /**
     * get by properties id
     *
     * @param id properties id
     * @return properties
     */
    Optional<ApiPropertiesJpaEntity> findByPropertiesId(String id);

    /**
     * get by channel id and properties id
     *
     * @param channelId channel id
     * @param id        properties id
     * @return properties
     */
    Optional<ApiPropertiesJpaEntity> findByChannelIdAndPropertiesId(String channelId, String id);
}
