package cn.shishuihao.thirdparty.api.core.impl.container;

import cn.shishuihao.thirdparty.api.core.ApiProperties;
import cn.shishuihao.thirdparty.api.core.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.core.Container;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class PropertiesContainerRepository extends AbstractContainerRepository<String, ApiProperties, ApiPropertiesRepository>
        implements ApiPropertiesRepository {
    public PropertiesContainerRepository(Container container) {
        super(container, ApiPropertiesRepository.class);
    }

    @Override
    public Optional<ApiProperties> getApiProperties(String channelId, String propertiesId) {
        return repository.getApiProperties(channelId, propertiesId);
    }
}
