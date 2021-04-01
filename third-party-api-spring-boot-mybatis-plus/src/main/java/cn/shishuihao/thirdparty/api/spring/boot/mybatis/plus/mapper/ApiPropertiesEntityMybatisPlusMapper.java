package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.mapper;

import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.entity.ApiConfigurationMybatisPlusEntity;
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
public interface ApiPropertiesEntityMybatisPlusMapper
        extends BaseMapper<ApiConfigurationMybatisPlusEntity> {
    /**
     * get api configuration.
     *
     * @param id configuration id
     * @return Optional<ApiConfigurationMybatisPlusEntity>
     */
    @Select("SELECT * FROM "
            + ApiConfigurationMybatisPlusEntity.TABLE_NAME
            + " WHERE "
            + ApiConfigurationMybatisPlusEntity.COLUMN_CONFIGURATION_ID
            + " = #{id}")
    Optional<ApiConfigurationMybatisPlusEntity>
    findByConfigurationId(@Param("id") String id);

    /**
     * get api configuration.
     *
     * @param appId     app id
     * @param channelId channel id
     * @return Optional<ApiConfigurationMybatisPlusEntity>
     */
    @Select("SELECT * FROM " + ApiConfigurationMybatisPlusEntity.TABLE_NAME
            + " WHERE "
            + ApiConfigurationMybatisPlusEntity.COLUMN_APP_ID
            + " = #{appId}"
            + " AND "
            + ApiConfigurationMybatisPlusEntity.COLUMN_CHANNEL_ID
            + "  = #{channelId}")
    Optional<ApiConfigurationMybatisPlusEntity>
    findByAppIdAndChannelId(@Param("appId") String appId,
                            @Param("channelId") String channelId);
}
