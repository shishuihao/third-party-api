package cn.shishuihao.thirdparty.api.core;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApiRegistry {
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
