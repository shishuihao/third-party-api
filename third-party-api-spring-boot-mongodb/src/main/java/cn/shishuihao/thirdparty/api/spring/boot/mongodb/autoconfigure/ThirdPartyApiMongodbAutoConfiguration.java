package cn.shishuihao.thirdparty.api.spring.boot.mongodb.autoconfigure;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.JacksonToApiPropertiesConverter;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.domain.ApiConfigurationMongodbDocumentConverter;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.domain.ApiConfigurationMongodbRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.domain.ApiPropertiesDocumentMongoRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.domain.ApiPropertiesToJacksonConverter;
import cn.shishuihao.thirdparty.api.spring.boot.starter.autoconfigure.ThirdPartyApiStarterAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration
@ConditionalOnProperty(
        name = "third-party-api.mongodb.enabled",
        matchIfMissing = true)
@EnableMongoRepositories(basePackages =
        "cn.shishuihao.thirdparty.api.spring.boot.mongodb.domain")
@AutoConfigureBefore(ThirdPartyApiStarterAutoConfiguration.class)
public class ThirdPartyApiMongodbAutoConfiguration {
    /**
     * apiConfigurationMongodbDocumentConverter.
     *
     * @return ApiConfigurationMongodbDocumentConverter
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiConfigurationMongodbDocumentConverter
    apiConfigurationMongodbDocumentConverter() {
        return new ApiConfigurationMongodbDocumentConverter();
    }

    /**
     * apiConfigurationRepository.
     *
     * @param repository repository
     * @param converter  converter
     * @return ApiConfigurationRepository
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiConfigurationRepository apiConfigurationRepository(
            final ApiPropertiesDocumentMongoRepository repository,
            final ApiConfigurationMongodbDocumentConverter converter) {
        return new ApiConfigurationMongodbRepository(repository, converter);
    }

    /**
     * mongoCustomConversions.
     *
     * @return MongoCustomConversions
     */
    @Bean
    @ConditionalOnMissingBean
    protected MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(Arrays.asList(
                new ApiPropertiesToJacksonConverter(),
                new JacksonToApiPropertiesConverter()
        ));
    }
}
