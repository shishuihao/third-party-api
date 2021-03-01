package cn.shishuihao.thirdparty.api.push.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.push.PushApiRequest;
import cn.shishuihao.thirdparty.api.push.api.PushMessageApi;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class PushMessageApiRequest extends AbstractRequest<PushMessageApi, PushMessageApiRequest, PushMessageApiResponse>
        implements PushApiRequest<PushMessageApi, PushMessageApiRequest, PushMessageApiResponse> {
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

    protected PushMessageApiRequest(String channelId, String propertiesId,
                                    String title, String payload, String description, String restrictedPackageName, String[] registrationIds) {
        super(channelId, propertiesId);
        this.title = title;
        this.payload = payload;
        this.description = description;
        this.restrictedPackageName = restrictedPackageName;
        this.registrationIds = registrationIds;
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
    public Class<PushMessageApi> apiType() {
        return PushMessageApi.class;
    }

    @Override
    public Class<PushMessageApiResponse> responseType() {
        return PushMessageApiResponse.class;
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

        public PushMessageApiRequest build() {
            return new PushMessageApiRequest(channelId, propertiesId, title, payload, description, restrictedPackageName, registrationIds);
        }
    }
}
