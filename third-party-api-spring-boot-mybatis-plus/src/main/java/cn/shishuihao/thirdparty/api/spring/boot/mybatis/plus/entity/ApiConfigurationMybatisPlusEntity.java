package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.entity;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.handler.ApiPropertiesJacksonTypeHandler;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
@TableName(value = ApiConfigurationMybatisPlusEntity.TABLE_NAME)
public class ApiConfigurationMybatisPlusEntity extends BaseMybatisPlusEntity {
    /**
     * table name api_configuration.
     */
    public static final String TABLE_NAME = "api_configuration";
    /**
     * column name configuration_id.
     */
    public static final String COLUMN_CONFIGURATION_ID = "configuration_id";
    /**
     * column name app_id.
     */
    public static final String COLUMN_APP_ID = "app_id";
    /**
     * column name channel_id.
     */
    public static final String COLUMN_CHANNEL_ID = "channel_id";
    /**
     * column name properties.
     */
    public static final String COLUMN_PROPERTIES = "properties";
    /**
     * configuration id.
     */
    @TableField(value = COLUMN_CONFIGURATION_ID)
    private String configurationId;
    /**
     * app id.
     */
    @TableField(value = COLUMN_APP_ID)
    private String appId;
    /**
     * channel id.
     */
    @TableField(value = COLUMN_CHANNEL_ID)
    private String channelId;
    /**
     * properties.
     */
    @TableField(
            value = COLUMN_PROPERTIES,
            typeHandler = ApiPropertiesJacksonTypeHandler.class)
    private ApiProperties properties;
}
