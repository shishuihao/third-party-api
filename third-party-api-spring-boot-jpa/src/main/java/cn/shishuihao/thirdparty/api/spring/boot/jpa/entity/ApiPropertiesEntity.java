package cn.shishuihao.thirdparty.api.spring.boot.jpa.entity;

import cn.shishuihao.thirdparty.api.core.ApiProperties;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.converter.ApiPropertiesJacksonAttributeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Table(name = ApiPropertiesEntity.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(columnNames = {ApiPropertiesEntity.COLUMN_CHANNEL_ID, ApiPropertiesEntity.COLUMN_PROPERTIES_ID})
})
@Entity
public class ApiPropertiesEntity extends BaseEntity {
    public static final String TABLE_NAME = "`api_properties`";
    public static final String COLUMN_CHANNEL_ID = "`channel_id`";
    public static final String COLUMN_PROPERTIES_ID = "`properties_id`";
    public static final String COLUMN_PROPERTIES = "`properties`";
    /**
     * channel id
     */
    @Column(name = COLUMN_CHANNEL_ID, nullable = false)
    private String channelId;
    /**
     * properties id
     */
    @Column(name = COLUMN_PROPERTIES_ID, nullable = false)
    private String propertiesId;
    /**
     * properties
     */
    @Convert(converter = ApiPropertiesJacksonAttributeConverter.class)
    @Column(name = COLUMN_PROPERTIES, length = 10240)
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
