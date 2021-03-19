package cn.shishuihao.thirdparty.api.spring.boot.mongodb.autoconfigure;

import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.ThirdPartyApiAutoConfiguration;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.ApiPropertiesMongodbRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.converter.ApiPropertiesMongodbDocumentConverter;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.converter.ApiPropertiesToJacksonConverter;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.converter.JacksonToApiPropertiesConverter;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.repository.ApiPropertiesDocumentMongoRepository;
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
        "cn.shishuihao.thirdparty.api.spring.boot.mongodb.repository")
@AutoConfigureBefore(ThirdPartyApiAutoConfiguration.class)
public class ThirdPartyApiMongodbAutoConfiguration {
    /**
     * ApiPropertiesMongodbDocumentConverter.
     *
     * @return ApiPropertiesMongodbDocumentConverter
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesMongodbDocumentConverter
    apiPropertiesMongodbDocumentConverter() {
        return new ApiPropertiesMongodbDocumentConverter();
    }

    /**
     * propertiesRepository.
     *
     * @param mongoRepository mongoRepository
     * @param converter       converter
     * @return ApiPropertiesRepository
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesRepository propertiesRepository(
            final ApiPropertiesDocumentMongoRepository mongoRepository,
            final ApiPropertiesMongodbDocumentConverter converter) {
        return new ApiPropertiesMongodbRepository(mongoRepository, converter);
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
