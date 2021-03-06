package cn.shishuihao.thirdparty.api.core.properties;

import cn.shishuihao.thirdparty.api.core.api.Api;
import cn.shishuihao.thirdparty.api.core.container.ContainerHolder;
import cn.shishuihao.thirdparty.api.core.exception.PropertiesNotFoundException;
import cn.shishuihao.thirdparty.api.core.request.ApiRequest;
import cn.shishuihao.thirdparty.api.core.response.ApiResponse;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public final class ApiPropertiesHolder {
    /**
     * api properties repository.
     */
    public static final ApiPropertiesRepository PROPERTIES_REPOSITORY;
    /**
     * properties not found message.
     */
    private static final String PROPERTIES_NOT_FOUND_MESSAGE
            = "properties not found by propertiesId:";

    static {
        PROPERTIES_REPOSITORY = Optional.ofNullable(ContainerHolder.CONTAINER)
                .map(container -> (ApiPropertiesRepository)
                        new ApiPropertiesContainerRepository(container, true))
                .orElseGet(() -> new ApiPropertiesMemoryRepository(true));
    }

    private ApiPropertiesHolder() {
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
        return PROPERTIES_REPOSITORY.getApiProperties(
                request.channelId(),
                request.propertiesId());
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
                        PROPERTIES_NOT_FOUND_MESSAGE + request.propertiesId()));
    }
}
