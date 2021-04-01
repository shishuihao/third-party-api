package cn.shishuihao.thirdparty.api.spring.boot.mongodb.domain;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.BaseMongodbDocument;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
@CompoundIndex(
        name = "cid_pid_uk",
        def = "{'"
                + ApiConfigurationMongodbDocument.COLUMN_CHANNEL_ID
                + "': 1, '"
                + ApiConfigurationMongodbDocument.COLUMN_CONFIGURATION_ID
                + "': 1}",
        unique = true)
@Document(collection = ApiConfigurationMongodbDocument.TABLE_NAME)
public class ApiConfigurationMongodbDocument extends BaseMongodbDocument {
    /**
     * document name api_configuration.
     */
    public static final String TABLE_NAME = "api_configuration";
    /**
     * field name configuration_id.
     */
    public static final String COLUMN_CONFIGURATION_ID = "configuration_id";
    /**
     * field name app_id.
     */
    public static final String COLUMN_APP_ID = "app_id";
    /**
     * field name channel_id.
     */
    public static final String COLUMN_CHANNEL_ID = "channel_id";
    /**
     * field name properties.
     */
    public static final String COLUMN_PROPERTIES = "properties";
    /**
     * configuration id.
     */
    @Field(name = COLUMN_CONFIGURATION_ID)
    private String configurationId;
    /**
     * app id.
     */
    @Field(name = COLUMN_APP_ID)
    private String appId;
    /**
     * channel id.
     */
    @Field(name = COLUMN_CHANNEL_ID)
    private String channelId;
    /**
     * properties.
     */
    @Field(name = COLUMN_PROPERTIES)
    private ApiProperties properties;
}
