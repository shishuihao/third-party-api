package cn.shishuihao.thirdparty.api.core.impl.container;

import cn.shishuihao.thirdparty.api.core.ApiChannel;
import cn.shishuihao.thirdparty.api.core.ApiChannelRepository;
import cn.shishuihao.thirdparty.api.core.Container;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ChannelContainerRepository extends AbstractContainerRepository<String, ApiChannel> implements ApiChannelRepository {
    public ChannelContainerRepository(Container container) {
        super(container, ApiChannelRepository.class);
    }
}
