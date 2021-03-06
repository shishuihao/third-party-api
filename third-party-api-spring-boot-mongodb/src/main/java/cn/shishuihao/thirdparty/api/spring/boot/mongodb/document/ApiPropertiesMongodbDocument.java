package cn.shishuihao.thirdparty.api.spring.boot.mongodb.document;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@CompoundIndex(name = "cid_pid_uk", def = "{'"
        + ApiPropertiesMongodbDocument.COLUMN_CHANNEL_ID + "': 1, '"
        + ApiPropertiesMongodbDocument.COLUMN_PROPERTIES_ID + "': 1}", unique = true)
@Document(collection = ApiPropertiesMongodbDocument.TABLE_NAME)
public class ApiPropertiesMongodbDocument extends BaseMongodbDocument {
    public static final String TABLE_NAME = "api_properties";
    public static final String COLUMN_CHANNEL_ID = "channel_id";
    public static final String COLUMN_PROPERTIES_ID = "properties_id";
    public static final String COLUMN_PROPERTIES = "properties";
    /**
     * channel id
     */
    @Field(name = COLUMN_CHANNEL_ID)
    private String channelId;
    /**
     * properties id
     */
    @Field(name = COLUMN_PROPERTIES_ID)
    private String propertiesId;
    /**
     * properties
     */
    @Field(name = COLUMN_PROPERTIES)
    private ApiProperties properties;

    public static ApiPropertiesMongodbDocument from(ApiProperties apiProperties) {
        ApiPropertiesMongodbDocument mongodbDocument = new ApiPropertiesMongodbDocument();
        mongodbDocument.setChannelId(apiProperties.channelId());
        mongodbDocument.setPropertiesId(apiProperties.id());
        mongodbDocument.setProperties(apiProperties);
        mongodbDocument.setGmtModified(LocalDateTime.now());
        return mongodbDocument;
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
