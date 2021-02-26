package cn.shishuihao.thirdparty.api.spring.boot.jpa.entity;

import cn.shishuihao.thirdparty.api.core.ApiProperties;
import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.PropertiesCastException;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;

import javax.persistence.*;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Table(name = ApiPropertiesEntity.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(columnNames = {ApiPropertiesEntity.CHANNEL_ID, ApiPropertiesEntity.PROPERTIES_ID})
})
@Entity
public class ApiPropertiesEntity extends BaseEntity {
    public static final String TABLE_NAME = "api_properties";
    public static final String CHANNEL_ID = "channel_id";
    public static final String PROPERTIES_ID = "properties_id";
    /**
     * channel id
     */
    @Column(name = CHANNEL_ID, nullable = false)
    private String channelId;
    /**
     * properties id
     */
    @Column(name = PROPERTIES_ID, nullable = false)
    private String propertiesId;
    /**
     * properties
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = ApiPropertyEntity.TABLE_NAME, joinColumns = @JoinColumn(name = PROPERTIES_ID))
    @MapKeyColumn(name = ApiPropertyEntity.KEY)
    @Column(name = ApiPropertyEntity.VALUE, length = 10240)
    private Map<String, String> properties;

    @SuppressWarnings("unchecked")
    public static ApiPropertiesEntity from(ApiProperties apiProperties) {
        ApiPropertiesEntity po = new ApiPropertiesEntity();
        po.setChannelId(apiProperties.channelId());
        po.setPropertiesId(apiProperties.id());
        po.setProperties(BeanMap.create(apiProperties));
        po.setGmtModified(LocalDateTime.now());
        return po;
    }

    public ApiProperties toApiProperties() {
        try {
            ApiProperties apiProperties = ApiRegistry.INSTANCE.getApiChannelOrThrow(channelId).newProperties();
            // 拷贝自身
            BeanUtils.copyProperties(this, apiProperties);
            // 拷贝map
            BeanMap beanMap = BeanMap.create(apiProperties);
            Optional.ofNullable(this.properties).ifPresent(it -> it.forEach(beanMap::put));
            return apiProperties;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new PropertiesCastException(e);
        }
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

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}
