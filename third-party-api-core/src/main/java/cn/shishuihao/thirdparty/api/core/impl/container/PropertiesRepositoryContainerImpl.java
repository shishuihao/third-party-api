package cn.shishuihao.thirdparty.api.core.impl.container;

import cn.shishuihao.thirdparty.api.core.Container;
import cn.shishuihao.thirdparty.api.core.Properties;
import cn.shishuihao.thirdparty.api.core.PropertiesRepository;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class PropertiesRepositoryContainerImpl extends AbstractRepositoryContainerImpl<String, Properties> implements PropertiesRepository {
    public PropertiesRepositoryContainerImpl(Container container) {
        super(container, PropertiesRepository.class);
    }
}
