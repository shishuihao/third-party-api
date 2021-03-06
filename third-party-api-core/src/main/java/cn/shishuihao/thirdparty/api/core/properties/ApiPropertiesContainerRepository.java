package cn.shishuihao.thirdparty.api.core.properties;

import cn.shishuihao.thirdparty.api.core.container.AbstractContainerRepository;
import cn.shishuihao.thirdparty.api.core.container.Container;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApiPropertiesContainerRepository extends AbstractContainerRepository<String, ApiProperties, ApiPropertiesRepository>
        implements ApiPropertiesRepository {

    public ApiPropertiesContainerRepository(Container container, boolean load) {
        super(container, ApiPropertiesRepository.class);
        if (load) {
            container.awareOrHook(it -> {
                // spi => container bean
                ServiceLoader.load(ApiProperties.class).forEach(repository::add);
                // container bean => container bean
                it.getBeansOfType(ApiProperties.class).values().forEach(repository::add);
            });
        }
    }

    public ApiPropertiesContainerRepository(Container container) {
        this(container, false);
    }


    @Override
    public Optional<ApiProperties> getApiProperties(String channelId, String propertiesId) {
        return repository.getApiProperties(channelId, propertiesId);
    }
}
