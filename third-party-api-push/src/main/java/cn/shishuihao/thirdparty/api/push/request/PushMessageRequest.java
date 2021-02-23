package cn.shishuihao.thirdparty.api.push.request;

import cn.shishuihao.thirdparty.api.push.PushRequest;
import cn.shishuihao.thirdparty.api.push.api.PushMessageApi;
import cn.shishuihao.thirdparty.api.push.response.PushMessageResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class PushMessageRequest implements PushRequest<PushMessageApi, PushMessageRequest, PushMessageResponse> {
    /**
     * channel id
     */
    private final String channelId;
    /**
     * properties id
     */
    private final String propertiesId;
    /**
     * title
     */
    private final String title;
    /**
     * payload
     */
    private final String payload;
    /**
     * description
     */
    private final String description;
    /**
     * restricted package name
     */
    private final String restrictedPackageName;
    /**
     * registration ids
     */
    private final String[] registrationIds;

    protected PushMessageRequest(String channelId, String propertiesId,
                                 String title, String payload, String description, String restrictedPackageName, String[] registrationIds) {
        this.channelId = channelId;
        this.propertiesId = propertiesId;
        this.title = title;
        this.payload = payload;
        this.description = description;
        this.restrictedPackageName = restrictedPackageName;
        this.registrationIds = registrationIds;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getPropertiesId() {
        return propertiesId;
    }

    public String getTitle() {
        return title;
    }

    public String getPayload() {
        return payload;
    }

    public String getDescription() {
        return description;
    }

    public String getRestrictedPackageName() {
        return restrictedPackageName;
    }

    public String[] getRegistrationIds() {
        return registrationIds;
    }

    @Override
    public Class<PushMessageResponse> responseClass() {
        return PushMessageResponse.class;
    }

    @Override
    public String channelId() {
        return channelId;
    }

    @Override
    public Class<PushMessageApi> apiType() {
        return PushMessageApi.class;
    }


    public static final class Builder {
        private String channelId;
        private String propertiesId;
        private String title;
        private String payload;
        private String description;
        private String restrictedPackageName;
        private String[] registrationIds;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder channelId(String channelId) {
            this.channelId = channelId;
            return this;
        }

        public Builder propertiesId(String propertiesId) {
            this.propertiesId = propertiesId;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder payload(String payload) {
            this.payload = payload;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder restrictedPackageName(String restrictedPackageName) {
            this.restrictedPackageName = restrictedPackageName;
            return this;
        }

        public Builder registrationIds(String[] registrationIds) {
            this.registrationIds = registrationIds;
            return this;
        }

        public PushMessageRequest build() {
            return new PushMessageRequest(channelId, propertiesId, title, payload, description, restrictedPackageName, registrationIds);
        }
    }
}
