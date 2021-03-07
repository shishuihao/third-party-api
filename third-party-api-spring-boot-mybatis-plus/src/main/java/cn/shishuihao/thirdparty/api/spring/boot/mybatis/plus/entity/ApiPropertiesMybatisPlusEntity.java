package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.entity;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.handler.ApiPropertiesJacksonTypeHandler;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
@TableName(value = ApiPropertiesMybatisPlusEntity.TABLE_NAME)
public class ApiPropertiesMybatisPlusEntity extends BaseMybatisPlusEntity {
    /**
     * table name api_properties.
     */
    public static final String TABLE_NAME = "api_properties";
    /**
     * column name channel_id.
     */
    public static final String COLUMN_CHANNEL_ID = "channel_id";
    /**
     * column name properties_id.
     */
    public static final String COLUMN_PROPERTIES_ID = "properties_id";
    /**
     * column name properties.
     */
    public static final String COLUMN_PROPERTIES = "properties";
    /**
     * channel id.
     */
    @TableField(value = COLUMN_CHANNEL_ID)
    private String channelId;
    /**
     * properties id.
     */
    @TableField(value = COLUMN_PROPERTIES_ID)
    private String propertiesId;
    /**
     * properties.
     */
    @TableField(
            value = COLUMN_PROPERTIES,
            typeHandler = ApiPropertiesJacksonTypeHandler.class)
    private ApiProperties properties;

    /**
     * from apiProperties to ApiPropertiesMybatisPlusEntity.
     *
     * @param properties apiProperties
     * @return ApiPropertiesMybatisPlusEntity
     */
    public static ApiPropertiesMybatisPlusEntity from(
            final ApiProperties properties) {
        ApiPropertiesMybatisPlusEntity mpEntity
                = new ApiPropertiesMybatisPlusEntity();
        mpEntity.setChannelId(properties.channelId());
        mpEntity.setPropertiesId(properties.id());
        mpEntity.setProperties(properties);
        mpEntity.setGmtModified(LocalDateTime.now());
        return mpEntity;
    }
}
