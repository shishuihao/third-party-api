package cn.shishuihao.thirdparty.api.spring.boot.jpa.autoconfigure;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.ApiConfigurationJpaRepository;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.converter.ApiConfigurationJpaEntityConverter;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.repository.ApiConfigurationEntityJpaRepository;
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
     * apiConfigurationJpaEntityConverter.
     *
     * @return ApiConfigurationJpaEntityConverter
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiConfigurationJpaEntityConverter
    apiConfigurationJpaEntityConverter() {
        return new ApiConfigurationJpaEntityConverter();
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
            final ApiConfigurationEntityJpaRepository repository,
            final ApiConfigurationJpaEntityConverter converter) {
        return new ApiConfigurationJpaRepository(repository, converter);
    }
}
