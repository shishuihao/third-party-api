package cn.shishuihao.thirdparty.api.core;

import cn.shishuihao.thirdparty.api.core.exception.ApiNotFoundException;
import cn.shishuihao.thirdparty.api.core.exception.ChannelNotFoundException;
import cn.shishuihao.thirdparty.api.core.exception.PropertiesNotFoundException;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiRegistry {
    public static final ApiPropertiesRepository PROPERTIES_REPOSITORY;
    public static final ApiChannelRepository CHANNEL_REPOSITORY;
    public static final ApiRegistry INSTANCE;

    static {
        PROPERTIES_REPOSITORY = ApiPropertiesHolder.PROPERTIES_REPOSITORY;
        CHANNEL_REPOSITORY = ApiChannelHolder.CHANNEL_REPOSITORY;
        INSTANCE = new ApiRegistry(CHANNEL_REPOSITORY);
    }

    private final ApiChannelRepository channelRepository;

    public ApiRegistry(ApiChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public Optional<ApiChannel<?>> getApiChannel(final String channelId) {
        return this.channelRepository.getById(channelId);
    }

    public ApiChannel<?> getApiChannelOrThrow(final String channelId) {
        return this.getApiChannel(channelId).orElseThrow(() -> new ChannelNotFoundException("channel not found by channelId:" + channelId));
    }

    public <A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> Optional<ApiChannel<?>>
    getApiChannel(final T request) {
        return this.getApiChannel(request.channelId());
    }

    public <A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> ApiChannel<?>
    getApiChannelOrThrow(final T request) {
        return this.getApiChannelOrThrow(request.channelId());
    }

    public <A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> Optional<A>
    getApi(final T request) {
        return this.getApiChannelOrThrow(request).getApi(request.apiType());
    }

    public <A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> A
    getApiOrThrow(final T request) {
        return this.getApi(request).orElseThrow(() -> new ApiNotFoundException("api not found by apiType:" + request.apiType()));
    }

    public <A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> Optional<ApiProperties>
    getApiProperties(final T request) {
        return PROPERTIES_REPOSITORY.getApiProperties(request.channelId(), request.propertiesId());
    }

    public <A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> ApiProperties
    getApiPropertiesOrThrow(final T request) {
        return this.getApiProperties(request).orElseThrow(() -> new PropertiesNotFoundException("properties not found by propertiesId:" + request.propertiesId()));
    }

    public <A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> R execute(final T request) {
        return this.getApiOrThrow(request).execute(request);
    }
}
