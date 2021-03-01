package cn.shishuihao.thirdparty.api.core.channel;

import cn.shishuihao.thirdparty.api.core.container.AbstractContainerRepository;
import cn.shishuihao.thirdparty.api.core.container.Container;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApiChannelContainerRepository extends AbstractContainerRepository<String, ApiChannel<?>, ApiChannelRepository>
        implements ApiChannelRepository {
    public ApiChannelContainerRepository(Container container) {
        super(container, ApiChannelRepository.class);
    }
}
