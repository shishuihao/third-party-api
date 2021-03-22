package cn.shishuihao.thirdparty.api.spring.boot.jpa.autoconfigure;

import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.ApiPropertiesJpaRepository;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.converter.ApiPropertiesJpaEntityConverter;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.repository.ApiPropertiesEntityJpaRepository;
import cn.shishuihao.thirdparty.api.spring.boot.starter.autoconfigure.ThirdPartyApiStarterAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration
@ConditionalOnProperty(
        name = "third-party-api.jpa.enabled",
        matchIfMissing = true)
@EntityScan(basePackages =
        "cn.shishuihao.thirdparty.api.spring.boot.jpa.entity")
@EnableJpaRepositories(basePackages =
        "cn.shishuihao.thirdparty.api.spring.boot.jpa.repository")
@AutoConfigureBefore(ThirdPartyApiStarterAutoConfiguration.class)
public class ThirdPartyApiJpaAutoConfiguration {
    /**
     * apiPropertiesJpaEntityConverter.
     *
     * @return ApiPropertiesJpaEntityConverter
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesJpaEntityConverter
    apiPropertiesJpaEntityConverter() {
        return new ApiPropertiesJpaEntityConverter();
    }

    /**
     * ApiPropertiesRepository.
     *
     * @param repository repository
     * @param converter     converter
     * @return ApiPropertiesRepository
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesRepository propertiesRepository(
            final ApiPropertiesEntityJpaRepository repository,
            final ApiPropertiesJpaEntityConverter converter) {
        return new ApiPropertiesJpaRepository(repository, converter);
    }
}
