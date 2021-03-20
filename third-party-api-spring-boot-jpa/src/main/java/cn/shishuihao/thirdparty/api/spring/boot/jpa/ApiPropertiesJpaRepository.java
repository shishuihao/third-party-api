package cn.shishuihao.thirdparty.api.spring.boot.jpa;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.converter.ApiPropertiesJpaEntityConverter;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.entity.ApiPropertiesJpaEntity;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.repository.ApiPropertiesEntityJpaRepository;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiPropertiesJpaRepository
        extends AbstractJpaRepository<
        String,
        ApiProperties,
        ApiPropertiesJpaEntity,
        ApiPropertiesEntityJpaRepository>
        implements ApiPropertiesRepository {
    /**
     * new ApiPropertiesJpaRepository.
     *
     * @param repository repository
     * @param converter  converter
     */
    public ApiPropertiesJpaRepository(
            final ApiPropertiesEntityJpaRepository repository,
            final ApiPropertiesJpaEntityConverter converter) {
        super(repository, converter);
    }

    /**
     * get entity by id.
     *
     * @param id id
     * @return option entity
     */
    @Override
    public Optional<ApiPropertiesJpaEntity> findById(final String id) {
        return this.getRepository()
                .findByPropertiesId(id);
    }

    /**
     * get api properties by channel id and properties id.
     *
     * @param channelId    channel id
     * @param propertiesId properties id
     * @return optional api properties
     */
    @Override
    public Optional<ApiProperties> getApiProperties(final String channelId,
                                                    final String propertiesId) {
        return this.getRepository()
                .findByChannelIdAndPropertiesId(channelId, propertiesId)
                .map(ApiPropertiesJpaEntity::getProperties);
    }
}
