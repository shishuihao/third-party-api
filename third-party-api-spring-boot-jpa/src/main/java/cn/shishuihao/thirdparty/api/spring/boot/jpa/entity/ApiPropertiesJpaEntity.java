package cn.shishuihao.thirdparty.api.spring.boot.jpa.entity;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.converter.ApiPropertiesJacksonAttributeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Table(name = ApiPropertiesJpaEntity.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(columnNames = {ApiPropertiesJpaEntity.COLUMN_CHANNEL_ID, ApiPropertiesJpaEntity.COLUMN_PROPERTIES_ID})
})
@Entity
public class ApiPropertiesJpaEntity extends BaseJpaEntity {
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

    public static ApiPropertiesJpaEntity from(ApiProperties apiProperties) {
        ApiPropertiesJpaEntity jpaEntity = new ApiPropertiesJpaEntity();
        jpaEntity.setChannelId(apiProperties.channelId());
        jpaEntity.setPropertiesId(apiProperties.id());
        jpaEntity.setProperties(apiProperties);
        jpaEntity.setGmtModified(LocalDateTime.now());
        return jpaEntity;
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
