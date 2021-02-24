package cn.shishuihao.thirdparty.api.core.impl.container;

import cn.shishuihao.thirdparty.api.core.Channel;
import cn.shishuihao.thirdparty.api.core.ChannelRepository;
import cn.shishuihao.thirdparty.api.core.Container;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ChannelRepositoryContainerImpl extends AbstractRepositoryContainerImpl<String, Channel> implements ChannelRepository {
    public ChannelRepositoryContainerImpl(Container container) {
        super(container, ChannelRepository.class);
    }
}
