package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.entity.ApiPropertiesMybatisPlusEntity;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.mapper.ApiPropertiesEntityMybatisPlusMapper;
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
    private final ApiPropertiesEntityMybatisPlusMapper mpMapper;

    /**
     * add api properties.
     *
     * @param apiProperties api properties
     */
    @Override
    public void add(final ApiProperties apiProperties) {
        Optional<ApiPropertiesMybatisPlusEntity> optional
                = mpMapper.findByPropertiesId(apiProperties.id());
        ApiPropertiesMybatisPlusEntity entity;
        if (optional.isPresent()) {
            entity = optional.get();
            entity.setProperties(apiProperties);
            entity.setGmtModified(LocalDateTime.now());
            mpMapper.updateById(entity);
        } else {
            entity = ApiPropertiesMybatisPlusEntity.from(apiProperties);
            mpMapper.insert(entity);
        }
    }

    /**
     * get api properties by properties id.
     *
     * @param propertiesId api properties id
     * @return optional api properties
     */
    @Override
    public Optional<ApiProperties> get(final String propertiesId) {
        return mpMapper
                .findByPropertiesId(propertiesId)
                .map(ApiPropertiesMybatisPlusEntity::getProperties);
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
        return mpMapper
                .findByChannelIdAndPropertiesId(channelId, propertiesId)
                .map(ApiPropertiesMybatisPlusEntity::getProperties);
    }
}
