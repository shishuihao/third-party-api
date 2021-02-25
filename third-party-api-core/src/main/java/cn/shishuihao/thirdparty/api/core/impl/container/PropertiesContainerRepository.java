package cn.shishuihao.thirdparty.api.core.impl.container;

import cn.shishuihao.thirdparty.api.core.ApiProperties;
import cn.shishuihao.thirdparty.api.core.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.core.Container;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class PropertiesContainerRepository extends AbstractContainerRepository<String, ApiProperties> implements ApiPropertiesRepository {
    public PropertiesContainerRepository(Container container) {
        super(container, ApiPropertiesRepository.class);
    }
}
