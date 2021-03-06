package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.entity.ApiPropertiesMybatisPlusEntity;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.mapper.ApiPropertiesEntityMybatisPlusMapper;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiPropertiesMybatisPlusRepository implements ApiPropertiesRepository {
    private final ApiPropertiesEntityMybatisPlusMapper mybatisPlusMapper;

    public ApiPropertiesMybatisPlusRepository(ApiPropertiesEntityMybatisPlusMapper mybatisPlusMapper) {
        this.mybatisPlusMapper = mybatisPlusMapper;
    }

    @Override
    public void add(final ApiProperties apiProperties) {
        Optional<ApiPropertiesMybatisPlusEntity> optional = mybatisPlusMapper.findByPropertiesId(apiProperties.id());
        ApiPropertiesMybatisPlusEntity entity;
        if (optional.isPresent()) {
            entity = optional.get();
            entity.setProperties(apiProperties);
            entity.setGmtModified(LocalDateTime.now());
            mybatisPlusMapper.updateById(entity);
        } else {
            entity = ApiPropertiesMybatisPlusEntity.from(apiProperties);
            mybatisPlusMapper.insert(entity);
        }
    }

    @Override
    public Optional<ApiProperties> getById(final String propertiesId) {
        return mybatisPlusMapper.findByPropertiesId(propertiesId)
                .map(ApiPropertiesMybatisPlusEntity::getProperties);
    }

    @Override
    public Optional<ApiProperties> getApiProperties(final String channelId, final String propertiesId) {
        return mybatisPlusMapper.findByChannelIdAndPropertiesId(channelId, propertiesId)
                .map(ApiPropertiesMybatisPlusEntity::getProperties);
    }
}
