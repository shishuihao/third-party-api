package cn.shishuihao.thirdparty.api.spring.boot.mongodb.document;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
@CompoundIndex(
        name = "cid_pid_uk",
        def = "{'"
                + ApiPropertiesMongodbDocument.COLUMN_CHANNEL_ID + "': 1, '"
                + ApiPropertiesMongodbDocument.COLUMN_PROPERTIES_ID + "': 1}",
        unique = true)
@Document(collection = ApiPropertiesMongodbDocument.TABLE_NAME)
public class ApiPropertiesMongodbDocument extends BaseMongodbDocument {
    /**
     * document name api_properties.
     */
    public static final String TABLE_NAME = "api_properties";
    /**
     * field name channel_id.
     */
    public static final String COLUMN_CHANNEL_ID = "channel_id";
    /**
     * field name properties_id.
     */
    public static final String COLUMN_PROPERTIES_ID = "properties_id";
    /**
     * field name properties.
     */
    public static final String COLUMN_PROPERTIES = "properties";
    /**
     * channel id.
     */
    @Field(name = COLUMN_CHANNEL_ID)
    private String channelId;
    /**
     * properties id.
     */
    @Field(name = COLUMN_PROPERTIES_ID)
    private String propertiesId;
    /**
     * properties.
     */
    @Field(name = COLUMN_PROPERTIES)
    private ApiProperties properties;

    /**
     * from apiProperties to ApiPropertiesMongodbDocument.
     *
     * @param properties apiProperties
     * @return ApiPropertiesMongodbDocument
     */
    public static ApiPropertiesMongodbDocument from(
            final ApiProperties properties) {
        ApiPropertiesMongodbDocument md = new ApiPropertiesMongodbDocument();
        md.setChannelId(properties.channelId());
        md.setPropertiesId(properties.id());
        md.setProperties(properties);
        md.setGmtModified(LocalDateTime.now());
        return md;
    }
}
