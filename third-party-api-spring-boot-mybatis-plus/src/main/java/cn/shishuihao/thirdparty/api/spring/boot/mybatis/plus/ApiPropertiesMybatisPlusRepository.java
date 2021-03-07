package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.entity.ApiPropertiesMpEntity;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.mapper.ApiPropertiesEntityMpMapper;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class ApiPropertiesMybatisPlusRepository
        implements ApiPropertiesRepository {
    /**
     * mybatisPlusMapper.
     */
    private final ApiPropertiesEntityMpMapper mpMapper;

    /**
     * add apiProperties.
     *
     * @param apiProperties entity
     */
    @Override
    public void add(final ApiProperties apiProperties) {
        Optional<ApiPropertiesMpEntity> optional = mpMapper
                .findByPropertiesId(apiProperties.id());
        ApiPropertiesMpEntity entity;
        if (optional.isPresent()) {
            entity = optional.get();
            entity.setProperties(apiProperties);
            entity.setGmtModified(LocalDateTime.now());
            mpMapper.updateById(entity);
        } else {
            entity = ApiPropertiesMpEntity.from(apiProperties);
            mpMapper.insert(entity);
        }
    }

    /**
     * get properties by id.
     *
     * @param propertiesId properties id
     * @return Optional<ApiProperties>
     */
    @Override
    public Optional<ApiProperties> getById(final String propertiesId) {
        return mpMapper.findByPropertiesId(propertiesId)
                .map(ApiPropertiesMpEntity::getProperties);
    }

    /**
     * get properties by channelId and propertiesId.
     *
     * @param propertiesId properties id
     * @return Optional<ApiProperties>
     */
    @Override
    public Optional<ApiProperties> getApiProperties(
            final String channelId,
            final String propertiesId) {
        return mpMapper
                .findByChannelIdAndPropertiesId(channelId, propertiesId)
                .map(ApiPropertiesMpEntity::getProperties);
    }
}
