package cn.shishuihao.thirdparty.api.spring.boot.jpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Repository
public interface ApiConfigurationEntityJpaRepository
        extends JpaRepository<ApiConfigurationJpaEntity, Long> {
    /**
     * get api configuration.
     *
     * @param id configuration id
     * @return Optional<ApiConfigurationJpaEntity>
     */
    Optional<ApiConfigurationJpaEntity>
    findByConfigurationId(String id);

    /**
     * get api configuration.
     *
     * @param appId     app id
     * @param channelId channel id
     * @return Optional<ApiConfigurationJpaEntity>
     */
    Optional<ApiConfigurationJpaEntity>
    findByAppIdAndChannelId(String appId, String channelId);
}
