package cn.shishuihao.thirdparty.api.core.configuration;

import cn.shishuihao.thirdparty.api.core.repository.Repository;

import java.util.Optional;

/**
 * api configuration repository.
 *
 * @author shishuihao
 * @version 1.0.0
 */
public interface ApiConfigurationRepository extends Repository<
        String,
        ApiConfiguration> {
    /**
     * get api configuration.
     *
     * @param appId     app id
     * @param channelId channel id
     * @return Optional<ApiConfiguration>
     */
    Optional<ApiConfiguration> getApiConfiguration(String appId,
                                                   String channelId);
}
