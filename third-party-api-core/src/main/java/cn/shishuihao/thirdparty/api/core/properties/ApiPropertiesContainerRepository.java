package cn.shishuihao.thirdparty.api.core.properties;

import cn.shishuihao.thirdparty.api.core.container.AbstractContainerRepository;
import cn.shishuihao.thirdparty.api.core.container.Container;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApiPropertiesContainerRepository extends AbstractContainerRepository<String, ApiProperties, ApiPropertiesRepository>
        implements ApiPropertiesRepository {
    public ApiPropertiesContainerRepository(Container container) {
        super(container, ApiPropertiesRepository.class);
    }

    @Override
    public Optional<ApiProperties> getApiProperties(String channelId, String propertiesId) {
        return repository.getApiProperties(channelId, propertiesId);
    }
}
