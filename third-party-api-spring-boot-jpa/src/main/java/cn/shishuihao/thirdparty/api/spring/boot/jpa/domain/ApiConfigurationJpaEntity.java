package cn.shishuihao.thirdparty.api.spring.boot.jpa.domain;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.BaseJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
@Table(
        name = ApiConfigurationJpaEntity.TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {
                        ApiConfigurationJpaEntity.COLUMN_CHANNEL_ID,
                        ApiConfigurationJpaEntity.COLUMN_CONFIGURATION_ID
                })
        })
@Entity
public class ApiConfigurationJpaEntity extends BaseJpaEntity {
    /**
     * table name api_configuration.
     */
    public static final String TABLE_NAME = "`api_configuration`";
    /**
     * column name configuration_id.
     */
    public static final String COLUMN_CONFIGURATION_ID = "`configuration_id`";
    /**
     * column name app_id.
     */
    public static final String COLUMN_APP_ID = "`app_id`";
    /**
     * column name channel_id.
     */
    public static final String COLUMN_CHANNEL_ID = "`channel_id`";
    /**
     * column name properties.
     */
    public static final String COLUMN_PROPERTIES = "`properties`";
    /**
     * column name properties length.
     */
    public static final int COLUMN_PROPERTIES_LENGTH = 10240;
    /**
     * configuration id.
     */
    @Column(name = COLUMN_CONFIGURATION_ID, nullable = false)
    private String configurationId;
    /**
     * app id.
     */
    @Column(name = COLUMN_APP_ID, nullable = false)
    private String appId;
    /**
     * channel id.
     */
    @Column(name = COLUMN_CHANNEL_ID, nullable = false)
    private String channelId;
    /**
     * properties.
     */
    @Convert(converter = ApiPropertiesJacksonAttributeConverter.class)
    @Column(name = COLUMN_PROPERTIES, length = COLUMN_PROPERTIES_LENGTH)
    private ApiProperties properties;
}
