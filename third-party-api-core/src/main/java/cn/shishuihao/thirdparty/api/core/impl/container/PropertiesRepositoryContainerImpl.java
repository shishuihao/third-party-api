package cn.shishuihao.thirdparty.api.core.impl.container;

import cn.shishuihao.thirdparty.api.core.Container;
import cn.shishuihao.thirdparty.api.core.ApiProperties;
import cn.shishuihao.thirdparty.api.core.ApiPropertiesRepository;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class PropertiesRepositoryContainerImpl extends AbstractRepositoryContainerImpl<String, ApiProperties> implements ApiPropertiesRepository {
    public PropertiesRepositoryContainerImpl(Container container) {
        super(container, ApiPropertiesRepository.class);
    }
}
