package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.converter.ApiPropertiesMybatisPlusEntityConverter;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.entity.ApiPropertiesMybatisPlusEntity;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.mapper.ApiPropertiesEntityMybatisPlusMapper;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiPropertiesMybatisPlusRepository
        extends AbstractMybatisPlusRepository<
        String,
        ApiProperties,
        ApiPropertiesMybatisPlusEntity,
        ApiPropertiesEntityMybatisPlusMapper>
        implements ApiPropertiesRepository {
    /**
     * new ApiPropertiesMybatisPlusRepository.
     *
     * @param mapper    mapper
     * @param converter converter
     */
    public ApiPropertiesMybatisPlusRepository(
            final ApiPropertiesEntityMybatisPlusMapper mapper,
            final ApiPropertiesMybatisPlusEntityConverter converter) {
        super(mapper, converter);
    }

    /**
     * get entity by id.
     *
     * @param id id
     * @return option entity
     */
    @Override
    public Optional<ApiPropertiesMybatisPlusEntity> findById(final String id) {
        return this.getBaseMapper()
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
        return this.getBaseMapper()
                .findByChannelIdAndPropertiesId(channelId, propertiesId)
                .map(ApiPropertiesMybatisPlusEntity::getProperties);
    }
}
