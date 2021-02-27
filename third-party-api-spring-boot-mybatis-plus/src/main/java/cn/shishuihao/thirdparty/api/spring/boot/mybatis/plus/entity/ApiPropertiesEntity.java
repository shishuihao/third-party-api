package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.entity;

import cn.shishuihao.thirdparty.api.core.ApiProperties;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.handler.ApiPropertiesJacksonTypeHandler;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@TableName(value = ApiPropertiesEntity.TABLE_NAME)
public class ApiPropertiesEntity extends BaseEntity {
    public static final String TABLE_NAME = "api_properties";
    public static final String COLUMN_CHANNEL_ID = "channel_id";
    public static final String COLUMN_PROPERTIES_ID = "properties_id";
    public static final String COLUMN_PROPERTIES = "properties";
    /**
     * channel id
     */
    @TableField(value = COLUMN_CHANNEL_ID)
    private String channelId;
    /**
     * properties id
     */
    @TableField(value = COLUMN_PROPERTIES_ID)
    private String propertiesId;
    /**
     * properties
     */
    @TableField(value = COLUMN_PROPERTIES, typeHandler = ApiPropertiesJacksonTypeHandler.class)
    private ApiProperties properties;

    public static ApiPropertiesEntity from(ApiProperties apiProperties) {
        ApiPropertiesEntity po = new ApiPropertiesEntity();
        po.setChannelId(apiProperties.channelId());
        po.setPropertiesId(apiProperties.id());
        po.setProperties(apiProperties);
        po.setGmtModified(LocalDateTime.now());
        return po;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getPropertiesId() {
        return propertiesId;
    }

    public void setPropertiesId(String propertiesId) {
        this.propertiesId = propertiesId;
    }

    public ApiProperties getProperties() {
        return properties;
    }

    public void setProperties(ApiProperties properties) {
        this.properties = properties;
    }
}
