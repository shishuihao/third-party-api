package cn.shishuihao.thirdparty.api.core;

import cn.shishuihao.thirdparty.api.core.exception.ApiNotFoundException;
import cn.shishuihao.thirdparty.api.core.exception.ChannelNotFoundException;
import cn.shishuihao.thirdparty.api.core.impl.ChannelRepositoryMemoryImpl;
import cn.shishuihao.thirdparty.api.core.impl.PropertiesRepositoryMemoryImpl;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApiRegistry {
    public static final PropertiesRepository PROPERTIES_REPOSITORY = new PropertiesRepositoryMemoryImpl();
    public static final ChannelRepository CHANNEL_REPOSITORY = new ChannelRepositoryMemoryImpl();
    public static final ApiRegistry INSTANCE = new ApiRegistry(CHANNEL_REPOSITORY);


    static {
        // spi
        ServiceLoader.load(Channel.class).forEach(INSTANCE.channelRepository::add);
    }

    private final ChannelRepository channelRepository;

    public ApiRegistry(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    /**
     * get api by request
     *
     * @param request request
     * @return optional api
     */
    public <A extends Api<A, T, R>, T extends Request<A, T, R>, R extends Response> Optional<A> getApi(final T request) {
        Channel channel = this.channelRepository.getById(request.channelId())
                .orElseThrow(() -> new ChannelNotFoundException("channel not found by channelId:" + request.channelId()));
        return channel.getApi(request.apiType());
    }

    /**
     * execute request
     *
     * @param request request
     * @return optional response
     */
    public <A extends Api<A, T, R>, T extends Request<A, T, R>, R extends Response> R execute(final T request) {
        A api = this.getApi(request)
                .orElseThrow(() -> new ApiNotFoundException("api not found by apiType:" + request.apiType()));
        return api.execute(request);
    }
}
