package cn.shishuihao.thirdparty.api.core.channel;

import cn.shishuihao.thirdparty.api.core.container.ContainerHolder;
import cn.shishuihao.thirdparty.api.core.exception.ChannelNotFoundException;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SuppressWarnings("rawtypes")
public class ApiChannelHolder {
    public static final ApiChannelRepository CHANNEL_REPOSITORY;

    static {
        CHANNEL_REPOSITORY = Optional.ofNullable(ContainerHolder.CONTAINER)
                .map(container -> (ApiChannelRepository) new ApiChannelContainerRepository(container, true))
                .orElseGet(() -> {
                    ApiChannelRepository repository = new ApiChannelMemoryRepository();
                    // spi => memory
                    ServiceLoader.load(ApiChannel.class).forEach(repository::add);
                    return repository;
                });
    }

    private ApiChannelHolder() {
    }

    public Optional<ApiChannel> getApiChannel(final String channelId) {
        return CHANNEL_REPOSITORY.getById(channelId).map(it -> it);
    }

    public ApiChannel getApiChannelOrThrow(final String channelId) {
        return this.getApiChannel(channelId).orElseThrow(() -> new ChannelNotFoundException("channel not found by channelId:" + channelId));
    }
}
