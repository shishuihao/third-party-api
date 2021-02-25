package cn.shishuihao.thirdparty.api.spring.boot.jpa.po;

import cn.shishuihao.thirdparty.api.core.ApiProperties;
import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.PropertiesCastException;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;

import javax.persistence.*;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Table
@Entity(name = "api_properties")
public class ApiPropertiesEntity extends BaseEntity {
    /**
     * channel id
     */
    @Column
    private String channelId;
    /**
     * properties id
     */
    @Column
    private String propertiesId;
    /**
     * properties
     */
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "api_property", joinColumns = @JoinColumn(name = "properties_id"))
    @MapKeyColumn(name = "`key`")
    @Column(name = "`value`", length = 10240)
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
            ApiProperties apiProperties = ApiRegistry.INSTANCE.getApiChannelOrThrow(channelId).propertiesType().getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(this, apiProperties);
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
