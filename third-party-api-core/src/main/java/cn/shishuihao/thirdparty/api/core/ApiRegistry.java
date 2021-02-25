package cn.shishuihao.thirdparty.api.core;

import cn.shishuihao.thirdparty.api.core.exception.ApiNotFoundException;
import cn.shishuihao.thirdparty.api.core.exception.ChannelNotFoundException;
import cn.shishuihao.thirdparty.api.core.exception.PropertiesNotFoundException;
import cn.shishuihao.thirdparty.api.core.impl.container.ChannelContainerRepository;
import cn.shishuihao.thirdparty.api.core.impl.container.PropertiesContainerRepository;
import cn.shishuihao.thirdparty.api.core.impl.memory.ChannelMemoryRepository;
import cn.shishuihao.thirdparty.api.core.impl.memory.PropertiesMemoryRepository;

import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiRegistry {
    public static final ApiPropertiesRepository PROPERTIES_REPOSITORY;
    public static final ApiChannelRepository CHANNEL_REPOSITORY;
    public static final ApiRegistry INSTANCE;
    protected static final Map<String, Container> CONTAINER_MAP = new ConcurrentHashMap<>();

    static {
        ServiceLoader.load(Container.class).forEach(container -> CONTAINER_MAP.put(container.id(), container));
        PROPERTIES_REPOSITORY = CONTAINER_MAP.values().stream()
                .findFirst()
                .map(container -> {
                    ApiPropertiesRepository repository = new PropertiesContainerRepository(container);
                    container.awareOrHook(it -> {
                        // spi => container bean
                        ServiceLoader.load(ApiProperties.class).forEach(repository::add);
                        // container bean => container bean
                        it.getBeansOfType(ApiProperties.class).values().forEach(repository::add);
                    });
                    return repository;
                })
                .orElseGet(() -> {
                    ApiPropertiesRepository repository = new PropertiesMemoryRepository();
                    // spi => memory
                    ServiceLoader.load(ApiProperties.class).forEach(repository::add);
                    return repository;
                });
        CHANNEL_REPOSITORY = CONTAINER_MAP.values().stream()
                .findFirst()
                .map(container -> {
                    ApiChannelRepository repository = new ChannelContainerRepository(container);
                    container.awareOrHook(it -> {
                        // spi => container bean
                        ServiceLoader.load(ApiChannel.class).forEach(repository::add);
                        // container bean => container bean
                        it.getBeansOfType(ApiChannel.class).values().forEach(repository::add);
                    });
                    return repository;
                })
                .orElseGet(() -> {
                    ApiChannelRepository repository = new ChannelMemoryRepository();
                    // spi => memory
                    ServiceLoader.load(ApiChannel.class).forEach(repository::add);
                    return repository;
                });
        INSTANCE = new ApiRegistry(CHANNEL_REPOSITORY);
    }

    private final ApiChannelRepository channelRepository;

    public ApiRegistry(ApiChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public <A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> Optional<ApiChannel<?>>
    getApiChannel(final T request) {
        return this.channelRepository.getById(request.channelId());
    }

    public <A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> ApiChannel<?>
    getApiChannelOrThrow(final T request) {
        return this.getApiChannel(request).orElseThrow(() -> new ChannelNotFoundException("channel not found by channelId:" + request.channelId()));
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
