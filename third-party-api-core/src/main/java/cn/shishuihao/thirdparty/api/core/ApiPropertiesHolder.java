package cn.shishuihao.thirdparty.api.core;

import cn.shishuihao.thirdparty.api.core.exception.PropertiesNotFoundException;
import cn.shishuihao.thirdparty.api.core.repository.container.ApiPropertiesContainerRepository;
import cn.shishuihao.thirdparty.api.core.repository.memory.ApiPropertiesMemoryRepository;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public abstract class ApiPropertiesHolder {
    public static final ApiPropertiesRepository PROPERTIES_REPOSITORY;

    static {
        PROPERTIES_REPOSITORY = Optional.ofNullable(ContainerHolder.CONTAINER)
                .map(container -> {
                    ApiPropertiesRepository repository = new ApiPropertiesContainerRepository(container);
                    container.awareOrHook(it -> {
                        // spi => container bean
                        ServiceLoader.load(ApiProperties.class).forEach(repository::add);
                        // container bean => container bean
                        it.getBeansOfType(ApiProperties.class).values().forEach(repository::add);
                    });
                    return repository;
                })
                .orElseGet(() -> {
                    ApiPropertiesRepository repository = new ApiPropertiesMemoryRepository();
                    // spi => memory
                    ServiceLoader.load(ApiProperties.class).forEach(repository::add);
                    return repository;
                });
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
