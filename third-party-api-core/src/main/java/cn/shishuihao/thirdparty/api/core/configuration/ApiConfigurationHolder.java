package cn.shishuihao.thirdparty.api.core.configuration;

import cn.shishuihao.thirdparty.api.core.api.Api;
import cn.shishuihao.thirdparty.api.core.container.ContainerHolder;
import cn.shishuihao.thirdparty.api.core.exception.PropertiesNotFoundException;
import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.request.ApiRequest;
import cn.shishuihao.thirdparty.api.core.response.ApiResponse;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public final class ApiConfigurationHolder {
    /**
     * api configuration repository.
     */
    public static final ApiConfigurationRepository CONFIGURATION_REPOSITORY;
    /**
     * configuration not found message.
     */
    public static final String CONFIGURATION_NOT_FOUND_MESSAGE
            = "configuration not found by appId:%s channelId:%s";

    static {
        CONFIGURATION_REPOSITORY = Optional
                .ofNullable(ContainerHolder.CONTAINER)
                .map(container -> (ApiConfigurationRepository)
                        new ApiConfigurationContainerRepository(container, true))
                .orElseGet(() -> new ApiConfigurationMemoryRepository(true));
    }

    private ApiConfigurationHolder() {
    }

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
    ApiProperties getApiPropertiesOrThrow(final T request) {
        return this.getApiProperties(request)
                .orElseThrow(() -> new PropertiesNotFoundException(
                        String.format(CONFIGURATION_NOT_FOUND_MESSAGE,
                                request.appId(),
                                request.channelId())));
    }
}
