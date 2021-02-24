package cn.shishuihao.thirdparty.api.core;

import cn.shishuihao.thirdparty.api.core.exception.ApiNotFoundException;
import cn.shishuihao.thirdparty.api.core.exception.ChannelNotFoundException;
import cn.shishuihao.thirdparty.api.core.impl.container.ChannelRepositoryContainerImpl;
import cn.shishuihao.thirdparty.api.core.impl.container.PropertiesRepositoryContainerImpl;
import cn.shishuihao.thirdparty.api.core.impl.memory.ChannelRepositoryMemoryImpl;
import cn.shishuihao.thirdparty.api.core.impl.memory.PropertiesRepositoryMemoryImpl;

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
                    ApiPropertiesRepository repository = new PropertiesRepositoryContainerImpl(container);
                    container.awareOrHook(it -> {
                        // spi => container bean
                        ServiceLoader.load(ApiProperties.class).forEach(repository::add);
                        // container bean => container bean
                        it.getBeansOfType(ApiProperties.class).values().forEach(repository::add);
                    });
                    return repository;
                })
                .orElseGet(() -> {
                    ApiPropertiesRepository repository = new PropertiesRepositoryMemoryImpl();
                    // spi => memory
                    ServiceLoader.load(ApiProperties.class).forEach(repository::add);
                    return repository;
                });
        CHANNEL_REPOSITORY = CONTAINER_MAP.values().stream()
                .findFirst()
                .map(container -> {
                    ApiChannelRepository repository = new ChannelRepositoryContainerImpl(container);
                    container.awareOrHook(it -> {
                        // spi => container bean
                        ServiceLoader.load(ApiChannel.class).forEach(repository::add);
                        // container bean => container bean
                        it.getBeansOfType(ApiChannel.class).values().forEach(repository::add);
                    });
                    return repository;
                })
                .orElseGet(() -> {
                    ApiChannelRepository repository = new ChannelRepositoryMemoryImpl();
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

    /**
     * get api by request
     *
     * @param request request
     * @return optional api
     */
    public <A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> Optional<A> getApi(final T request) {
        ApiChannel channel = this.channelRepository.getById(request.channelId())
                .orElseThrow(() -> new ChannelNotFoundException("channel not found by channelId:" + request.channelId()));
        return channel.getApi(request.apiType());
    }

    /**
     * execute request
     *
     * @param request request
     * @return optional response
     */
    public <A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> R execute(final T request) {
        A api = this.getApi(request)
                .orElseThrow(() -> new ApiNotFoundException("api not found by apiType:" + request.apiType()));
        return api.execute(request);
    }
}
