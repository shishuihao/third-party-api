package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.mapper;

import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.entity.ApiPropertiesMpEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Mapper
public interface ApiPropertiesEntityMpMapper
        extends BaseMapper<ApiPropertiesMpEntity> {
    /**
     * get by properties id.
     *
     * @param id properties id
     * @return properties
     */
    @Select("SELECT * FROM " + ApiPropertiesMpEntity.TABLE_NAME
            + " WHERE " + ApiPropertiesMpEntity.COLUMN_PROPERTIES_ID
            + " = #{id}")
    Optional<ApiPropertiesMpEntity>
    findByPropertiesId(@Param("id") String id);

    /**
     * get by channel id and properties id.
     *
     * @param channelId channel id
     * @param id        properties id
     * @return properties
     */
    @Select("SELECT * FROM " + ApiPropertiesMpEntity.TABLE_NAME
            + " WHERE " + ApiPropertiesMpEntity.COLUMN_CHANNEL_ID
            + " = #{channelId}"
            + " AND "
            + ApiPropertiesMpEntity.COLUMN_PROPERTIES_ID
            + "  = #{id}")
    Optional<ApiPropertiesMpEntity>
    findByChannelIdAndPropertiesId(@Param("channelId") String channelId,
                                   @Param("id") String id);
}
