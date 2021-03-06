package cn.shishuihao.thirdparty.api.core.channel;

import cn.shishuihao.thirdparty.api.core.container.ContainerHolder;
import cn.shishuihao.thirdparty.api.core.exception.ChannelNotFoundException;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SuppressWarnings("rawtypes")
public final class ApiChannelHolder {
    /**
     * channel repository.
     */
    public static final ApiChannelRepository CHANNEL_REPOSITORY;
    /**
     * channel not found message.
     */
    private static final String CHANNEL_NOT_FOUND_MESSAGE
            = "channel not found by channelId:";

    static {
        CHANNEL_REPOSITORY = Optional.ofNullable(ContainerHolder.CONTAINER)
                .map(container -> (ApiChannelRepository)
                        new ApiChannelContainerRepository(container, true))
                .orElseGet(() -> new ApiChannelMemoryRepository(true));
    }

    private ApiChannelHolder() {
    }

    /**
     * get api channel by channel id.
     *
     * @param channelId channel id
     * @return Optional<ApiChannel>
     */
    public Optional<ApiChannel> getApiChannel(final String channelId) {
        return CHANNEL_REPOSITORY.getById(channelId).map(it -> it);
    }

    /**
     * get api channel by channel id.
     * if channel not exists will throw ChannelNotFoundException.
     *
     * @param channelId channel id
     * @return Optional<ApiChannel>
     */
    public ApiChannel getApiChannelOrThrow(final String channelId) {
        return this.getApiChannel(channelId)
                .orElseThrow(() -> new ChannelNotFoundException(
                        CHANNEL_NOT_FOUND_MESSAGE + channelId));
    }
}
