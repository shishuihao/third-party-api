package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.domain;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.AbstractMybatisPlusRepository;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiConfigurationMybatisPlusRepository
        extends AbstractMybatisPlusRepository<
        String,
        ApiConfiguration,
        ApiConfigurationMybatisPlusEntity,
        ApiConfigurationEntityMybatisPlusMapper>
        implements ApiConfigurationRepository {
    /**
     * new ApiConfigurationMybatisPlusRepository.
     *
     * @param mapper    mapper
     * @param converter converter
     */
    public ApiConfigurationMybatisPlusRepository(
            final ApiConfigurationEntityMybatisPlusMapper mapper,
            final ApiConfigurationMybatisPlusEntityConverter converter) {
        super(mapper, converter);
    }

    /**
     * get entity by id.
     *
     * @param id id
     * @return Optional<ApiConfigurationMybatisPlusEntity>
     */
    @Override
    public Optional<ApiConfigurationMybatisPlusEntity> findById(
            final String id) {
        return this.getBaseMapper()
                .findByConfigurationId(id);
    }

    /**
     * get api configuration.
     *
     * @param appId     app id
     * @param channelId channel id
     * @return Optional<ApiConfiguration>
     */
    @Override
    public Optional<ApiConfiguration> getApiConfiguration(
            final String appId,
            final String channelId) {
        return this.getBaseMapper()
                .findByAppIdAndChannelId(appId, channelId)
                .map(this.getConverter()::convert);
    }
}
