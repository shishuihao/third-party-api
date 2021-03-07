package cn.shishuihao.thirdparty.api.spring.boot.jpa.entity;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.converter.ApiPropertiesJacksonAttributeConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
@Table(
        name = ApiPropertiesJpaEntity.TABLE_NAME,
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                ApiPropertiesJpaEntity.COLUMN_CHANNEL_ID,
                                ApiPropertiesJpaEntity.COLUMN_PROPERTIES_ID
                        })
        })
@Entity
public class ApiPropertiesJpaEntity extends BaseJpaEntity {
    /**
     * table name api_properties.
     */
    public static final String TABLE_NAME = "`api_properties`";
    /**
     * column name channel_id.
     */
    public static final String COLUMN_CHANNEL_ID = "`channel_id`";
    /**
     * column name properties_id.
     */
    public static final String COLUMN_PROPERTIES_ID = "`properties_id`";
    /**
     * column name properties.
     */
    public static final String COLUMN_PROPERTIES = "`properties`";
    /**
     * column name properties length.
     */
    public static final int COLUMN_PROPERTIES_LENGTH = 10240;
    /**
     * channel id.
     */
    @Column(name = COLUMN_CHANNEL_ID, nullable = false)
    private String channelId;
    /**
     * properties id.
     */
    @Column(name = COLUMN_PROPERTIES_ID, nullable = false)
    private String propertiesId;
    /**
     * properties.
     */
    @Convert(converter = ApiPropertiesJacksonAttributeConverter.class)
    @Column(name = COLUMN_PROPERTIES, length = COLUMN_PROPERTIES_LENGTH)
    private ApiProperties properties;

    /**
     * from apiProperties to ApiPropertiesJpaEntity.
     *
     * @param properties apiProperties
     * @return ApiPropertiesJpaEntity
     */
    public static ApiPropertiesJpaEntity from(
            final ApiProperties properties) {
        ApiPropertiesJpaEntity jpaEntity = new ApiPropertiesJpaEntity();
        jpaEntity.setChannelId(properties.channelId());
        jpaEntity.setPropertiesId(properties.id());
        jpaEntity.setProperties(properties);
        jpaEntity.setGmtModified(LocalDateTime.now());
        return jpaEntity;
    }
}
