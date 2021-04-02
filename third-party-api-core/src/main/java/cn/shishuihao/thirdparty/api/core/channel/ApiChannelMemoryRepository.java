package cn.shishuihao.thirdparty.api.core.channel;

import cn.shishuihao.thirdparty.api.core.repository.AbstractMemoryRepository;

import java.util.ServiceLoader;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiChannelMemoryRepository extends AbstractMemoryRepository<
        String,
        ApiChannel<?>> implements ApiChannelRepository {

    /**
     * new ApiChannelMemoryRepository.
     *
     * @param load whether load bean
     */
    public ApiChannelMemoryRepository(final boolean load) {
        if (load) {
            // spi => memory
            ServiceLoader.load(ApiChannel.class).forEach(this::save);
        }
    }

    /**
     * new ApiChannelMemoryRepository.
     */
    public ApiChannelMemoryRepository() {
        this(false);
    }
}
