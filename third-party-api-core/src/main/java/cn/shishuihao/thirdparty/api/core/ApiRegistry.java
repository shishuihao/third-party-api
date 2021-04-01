package cn.shishuihao.thirdparty.api.core;

import cn.shishuihao.thirdparty.api.core.api.Api;
import cn.shishuihao.thirdparty.api.core.channel.ApiChannel;
import cn.shishuihao.thirdparty.api.core.channel.ApiChannelHolder;
import cn.shishuihao.thirdparty.api.core.channel.ApiChannelRepository;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationHolder;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.core.event.EventPublisherHolder;
import cn.shishuihao.thirdparty.api.core.exception.ApiNotFoundException;
import cn.shishuihao.thirdparty.api.core.exception.ChannelNotFoundException;
import cn.shishuihao.thirdparty.api.core.exception.PropertiesNotFoundException;
import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.request.ApiRequest;
import cn.shishuihao.thirdparty.api.core.response.ApiResponse;

import java.util.Optional;

import static cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationHolder.CONFIGURATION_NOT_FOUND_MESSAGE;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ApiRegistry {
    /**
     * api configuration repository.
     */
    public static final ApiConfigurationRepository CONFIGURATION_REPOSITORY;
    /**
     * channel repository.
     */
    public static final ApiChannelRepository CHANNEL_REPOSITORY;
    /**
     * instance.
     */
    public static final ApiRegistry INSTANCE;
    /**
     * api not found message.
     */
    private static final String API_NOT_FOUND_MESSAGE
            = "api not found by apiType:";

    static {
        CONFIGURATION_REPOSITORY = ApiConfigurationHolder
                .CONFIGURATION_REPOSITORY;
        CHANNEL_REPOSITORY = ApiChannelHolder
                .CHANNEL_REPOSITORY;
        INSTANCE = new ApiRegistry(CHANNEL_REPOSITORY);
    }

    /**
     * channel repository.
     */
    private final ApiChannelRepository channelRepository;

    /**
     * new ApiRegistry.
     *
     * @param pChannelRepository channel repository
     */
    public ApiRegistry(final ApiChannelRepository pChannelRepository) {
        this.channelRepository = pChannelRepository;
    }

    // region getApiChannel

    /**
     * get channel by channel id.
     *
     * @param channelId channel id
     * @return Optional<ApiChannel>
     */
    public Optional<ApiChannel> getApiChannel(final String channelId) {
        return this.channelRepository.get(channelId).map(it -> it);
    }

    /**
     * get channel by channel id.
     * if channel not exists will throw ChannelNotFoundException.
     *
     * @param channelId channel id
     * @return ApiChannel
     */
    public ApiChannel getApiChannelOrThrow(final String channelId) {
        return this.getApiChannel(channelId)
                .orElseThrow(() -> new ChannelNotFoundException(
                        ApiChannelHolder.CHANNEL_REPOSITORY + channelId));
    }

    /**
     * get api channel by request.
     *
     * @param request request
     * @param <A>     api
     * @param <T>     request
     * @param <R>     response
     * @return Optional<ApiChannel>
     */
    public <A extends Api<A, T, R>,
            T extends ApiRequest<A, T, R>,
            R extends ApiResponse>
    Optional<ApiChannel> getApiChannel(final T request) {
        return this.getApiChannel(request.channelId());
    }

    /**
     * get api channel by request.
     * if channel not exists will throw ChannelNotFoundException.
     *
     * @param request request
     * @param <A>     api
     * @param <T>     request
     * @param <R>     response
     * @return ApiChannel
     */
    public <A extends Api<A, T, R>,
            T extends ApiRequest<A, T, R>,
            R extends ApiResponse>
    ApiChannel getApiChannelOrThrow(final T request) {
        return this.getApiChannelOrThrow(request.channelId());
    }

    // endregion

    // region getApi

    /**
     * get api by request.
     *
     * @param request request
     * @param <A>     api
     * @param <T>     request
     * @param <R>     response
     * @return Optional<A>
     */
    public <A extends Api<A, T, R>,
            T extends ApiRequest<A, T, R>,
            R extends ApiResponse>
    Optional<A> getApi(final T request) {
        return this.getApiChannelOrThrow(request).getApi(request.apiType());
    }

    /**
     * get api by request.
     * if channel not exists will throw ChannelNotFoundException.
     * if api not exists will throw ApiNotFoundException.
     *
     * @param request request
     * @param <A>     api
     * @param <T>     request
     * @param <R>     response
     * @return A
     */
    public <A extends Api<A, T, R>,
            T extends ApiRequest<A, T, R>,
            R extends ApiResponse>
    A getApiOrThrow(final T request) {
        return this.getApi(request)
                .orElseThrow(() -> new ApiNotFoundException(
                        API_NOT_FOUND_MESSAGE + request.apiType()));
    }

    // endregion

    // region getApiProperties

    /**
     * get api properties by request.
     *
     * @param request request
     * @param <A>     api
     * @param <T>     request
     * @param <R>     response
     * @return Optional<ApiProperties>
     */
    public <A extends Api<A, T, R>,
            T extends ApiRequest<A, T, R>,
            R extends ApiResponse>
    Optional<ApiProperties> getApiProperties(final T request) {
        return CONFIGURATION_REPOSITORY
                .getApiConfiguration(request.appId(), request.channelId())
                .map(ApiConfiguration::getProperties);
    }

    /**
     * get api properties by request.
     * if channel not exists will throw ChannelNotFoundException.
     * if api not exists will throw ApiNotFoundException.
     * if api properties not exists will throw PropertiesNotFoundException.
     * if api cast fail will throw PropertiesCastException.
     *
     * @param request request
     * @param <A>     api
     * @param <T>     request
     * @param <R>     response
     * @return ApiProperties
     */
    public <A extends Api<A, T, R>,
            T extends ApiRequest<A, T, R>,
            R extends ApiResponse>
    ApiProperties getApiPropertiesOrThrow(final T request) {
        return this.getApiProperties(request)
                .orElseThrow(() -> new PropertiesNotFoundException(
                        String.format(CONFIGURATION_NOT_FOUND_MESSAGE,
                                request.appId(),
                                request.channelId())));
    }

    // execute

    /**
     * execute request.
     * if channel not exists will throw ChannelNotFoundException.
     * if api not exists will throw ApiNotFoundException.
     * if api properties not exists will throw PropertiesNotFoundException.
     * if api cast fail will throw PropertiesCastException.
     *
     * @param request request
     * @param <A>     api
     * @param <T>     request
     * @param <R>     response
     * @return R
     */
    public <A extends Api<A, T, R>,
            T extends ApiRequest<A, T, R>,
            R extends ApiResponse>
    R execute(final T request) {
        R response = this.getApiOrThrow(request).execute(request);
        // publish event
        EventPublisherHolder.publishEvent(response);
        return response;
    }
}
