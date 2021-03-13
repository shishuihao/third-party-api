package cn.shishuihao.thirdparty.api.push.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.push.PushApiRequest;
import cn.shishuihao.thirdparty.api.push.api.PushMessageApi;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Jacksonized
@SuperBuilder
public class PushMessageApiRequest extends AbstractRequest<
        PushMessageApi,
        PushMessageApiRequest,
        PushMessageApiResponse> implements PushApiRequest<
        PushMessageApi,
        PushMessageApiRequest,
        PushMessageApiResponse> {
    /**
     * title.
     */
    private final String title;
    /**
     * payload.
     */
    private final String payload;
    /**
     * description.
     */
    private final String description;
    /**
     * restricted package name.
     */
    private final String restrictedPackageName;
    /**
     * registration ids.
     */
    private final String[] registrationIds;

    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    public Class<PushMessageApi> apiType() {
        return PushMessageApi.class;
    }

    /**
     * get properties id.
     * immutable
     *
     * @return properties id
     */
    @Override
    public Class<PushMessageApiResponse> responseType() {
        return PushMessageApiResponse.class;
    }
}
