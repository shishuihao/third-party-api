package cn.shishuihao.thirdparty.api.core;

import cn.shishuihao.thirdparty.api.core.exception.ChannelNotFoundException;
import cn.shishuihao.thirdparty.api.core.repository.container.ApiChannelContainerRepository;
import cn.shishuihao.thirdparty.api.core.repository.memory.ApiChannelMemoryRepository;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public abstract class ApiChannelHolder {
    public static final ApiChannelRepository CHANNEL_REPOSITORY;

    static {
        CHANNEL_REPOSITORY = Optional.ofNullable(ContainerHolder.CONTAINER)
                .map(container -> {
                    ApiChannelRepository repository = new ApiChannelContainerRepository(container);
                    container.awareOrHook(it -> {
                        // spi => container bean
                        ServiceLoader.load(ApiChannel.class).forEach(repository::add);
                        // container bean => container bean
                        it.getBeansOfType(ApiChannel.class).values().forEach(repository::add);
                    });
                    return repository;
                })
                .orElseGet(() -> {
                    ApiChannelRepository repository = new ApiChannelMemoryRepository();
                    // spi => memory
                    ServiceLoader.load(ApiChannel.class).forEach(repository::add);
                    return repository;
                });
    }

    public Optional<ApiChannel<?>> getApiChannel(final String channelId) {
        return CHANNEL_REPOSITORY.getById(channelId);
    }

    public ApiChannel<?> getApiChannelOrThrow(final String channelId) {
        return this.getApiChannel(channelId).orElseThrow(() -> new ChannelNotFoundException("channel not found by channelId:" + channelId));
    }
}
