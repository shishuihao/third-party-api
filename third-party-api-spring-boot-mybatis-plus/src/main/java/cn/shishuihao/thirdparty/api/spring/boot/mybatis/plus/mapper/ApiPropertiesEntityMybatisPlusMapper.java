package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.mapper;

import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.entity.ApiPropertiesEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Mapper
public interface ApiPropertiesEntityMybatisPlusMapper extends BaseMapper<ApiPropertiesEntity> {
    /**
     * get by properties id
     *
     * @param id properties id
     * @return properties
     */
    @Select("SELECT * FROM " + ApiPropertiesEntity.TABLE_NAME +
            " WHERE " + ApiPropertiesEntity.COLUMN_PROPERTIES_ID + " = #{id}")
    Optional<ApiPropertiesEntity> findByPropertiesId(String id);

    /**
     * get by channel id and properties id
     *
     * @param channelId channel id
     * @param id        properties id
     * @return properties
     */
    @Select("SELECT * FROM " + ApiPropertiesEntity.TABLE_NAME +
            " WHERE " + ApiPropertiesEntity.COLUMN_CHANNEL_ID + " = #{channelId}" +
            " AND " + ApiPropertiesEntity.COLUMN_PROPERTIES_ID + "  = #{id}")
    Optional<ApiPropertiesEntity> findByChannelIdAndPropertiesId(String channelId, String id);
}
