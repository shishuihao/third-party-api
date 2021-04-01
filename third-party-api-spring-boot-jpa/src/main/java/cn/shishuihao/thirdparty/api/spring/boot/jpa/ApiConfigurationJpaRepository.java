package cn.shishuihao.thirdparty.api.spring.boot.jpa;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.converter.ApiConfigurationJpaEntityConverter;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.entity.ApiConfigurationJpaEntity;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.repository.ApiConfigurationEntityJpaRepository;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiConfigurationJpaRepository
        extends AbstractJpaRepository<
        String,
        ApiConfiguration,
        ApiConfigurationJpaEntity,
        ApiConfigurationEntityJpaRepository>
        implements ApiConfigurationRepository {
    /**
     * new ApiConfigurationJpaRepository.
     *
     * @param repository repository
     * @param converter  converter
     */
    public ApiConfigurationJpaRepository(
            final ApiConfigurationEntityJpaRepository repository,
            final ApiConfigurationJpaEntityConverter converter) {
        super(repository, converter);
    }

    /**
     * get entity by id.
     *
     * @param id id
     * @return Optional<ApiConfigurationJpaEntity>
     */
    @Override
    public Optional<ApiConfigurationJpaEntity> findById(final String id) {
        return this.getJpaRepository()
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
        return this.getJpaRepository()
                .findByAppIdAndChannelId(appId, channelId)
                .map(this.getConverter()::convert);
    }
}
