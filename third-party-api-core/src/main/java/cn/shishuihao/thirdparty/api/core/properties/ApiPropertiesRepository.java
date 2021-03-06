package cn.shishuihao.thirdparty.api.core.properties;

import cn.shishuihao.thirdparty.api.core.repository.Repository;

import java.util.Optional;

/**
 * api properties repository.
 *
 * @author shishuihao
 * @version 1.0.0
 */
public interface ApiPropertiesRepository extends Repository<
        String,
        ApiProperties> {
    /**
     * get api properties by api type.
     *
     * @param channelId    channel id
     * @param propertiesId properties id
     * @return ApiProperties
     */
    Optional<ApiProperties> getApiProperties(String channelId,
                                             String propertiesId);
}
