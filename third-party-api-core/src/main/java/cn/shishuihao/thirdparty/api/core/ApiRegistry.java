package cn.shishuihao.thirdparty.api.core;

import cn.shishuihao.thirdparty.api.core.impl.ChannelRepositoryMemoryImpl;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApiRegistry {
    /**
     * spi
     */
    public static final ApiRegistry INSTANCE = new ApiRegistry(new ChannelRepositoryMemoryImpl());

    static {
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
    public <A extends Api<A, T, R>, T extends Request<A, T, R>, R extends Response> Optional<A> getApi(T request) {
        return channelRepository.getById(request.channelId())
                .flatMap(channel -> channel.getApi(request.apiType()));
    }

    /**
     * execute request
     *
     * @param request request
     * @return optional response
     */
    public <A extends Api<A, T, R>, T extends Request<A, T, R>, R extends Response> Optional<R> execute(T request) {
        return getApi(request).map(api -> api.execute(request));
    }
}
