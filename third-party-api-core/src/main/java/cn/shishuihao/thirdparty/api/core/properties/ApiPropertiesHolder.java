package cn.shishuihao.thirdparty.api.core.properties;

import cn.shishuihao.thirdparty.api.core.api.Api;
import cn.shishuihao.thirdparty.api.core.container.ContainerHolder;
import cn.shishuihao.thirdparty.api.core.exception.PropertiesNotFoundException;
import cn.shishuihao.thirdparty.api.core.request.ApiRequest;
import cn.shishuihao.thirdparty.api.core.response.ApiResponse;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiPropertiesHolder {
    public static final ApiPropertiesRepository PROPERTIES_REPOSITORY;

    static {
        PROPERTIES_REPOSITORY = Optional.ofNullable(ContainerHolder.CONTAINER)
                .map(container -> (ApiPropertiesRepository) new ApiPropertiesContainerRepository(container, true))
                .orElseGet(() -> {
                    ApiPropertiesRepository repository = new ApiPropertiesMemoryRepository();
                    // spi => memory
                    ServiceLoader.load(ApiProperties.class).forEach(repository::add);
                    return repository;
                });
    }

    private ApiPropertiesHolder() {
    }

    public <A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> Optional<ApiProperties>
    getApiProperties(final T request) {
        return PROPERTIES_REPOSITORY.getApiProperties(request.channelId(), request.propertiesId());
    }

    public <A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> ApiProperties
    getApiPropertiesOrThrow(final T request) {
        return this.getApiProperties(request).orElseThrow(() -> new PropertiesNotFoundException("properties not found by propertiesId:" + request.propertiesId()));
    }
}
