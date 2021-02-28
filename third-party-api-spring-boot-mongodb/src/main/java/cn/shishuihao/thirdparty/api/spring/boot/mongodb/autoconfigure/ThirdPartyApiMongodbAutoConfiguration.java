package cn.shishuihao.thirdparty.api.spring.boot.mongodb.autoconfigure;

import cn.shishuihao.thirdparty.api.core.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.ThirdPartyApiAutoConfiguration;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.ApiPropertiesMongodbRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.converter.ApiPropertiesToJacksonConverter;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.converter.JacksonToApiPropertiesConverter;
import cn.shishuihao.thirdparty.api.spring.boot.mongodb.repository.ApiPropertiesDocumentMongoRepository;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration
@ConditionalOnProperty(name = "third-party-api.mongodb.enabled", matchIfMissing = true)
@EnableMongoRepositories(basePackages = "cn.shishuihao.thirdparty.api.spring.boot.mongodb.repository")
@AutoConfigureBefore(ThirdPartyApiAutoConfiguration.class)
public class ThirdPartyApiMongodbAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesRepository propertiesRepository(ApiPropertiesDocumentMongoRepository mongoRepository) {
        return new ApiPropertiesMongodbRepository(mongoRepository);
    }

    @Bean
    @ConditionalOnMissingBean
    public CustomConversions customConversions() {
        List<Converter<?, ?>> converterList = new ArrayList<>();
        converterList.add(new ApiPropertiesToJacksonConverter());
        converterList.add(new JacksonToApiPropertiesConverter());
        return new MongoCustomConversions(converterList);
    }
}
