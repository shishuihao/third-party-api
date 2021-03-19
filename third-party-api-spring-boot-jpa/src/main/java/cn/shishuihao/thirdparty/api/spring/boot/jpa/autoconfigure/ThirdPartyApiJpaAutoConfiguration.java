package cn.shishuihao.thirdparty.api.spring.boot.jpa.autoconfigure;

import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.ThirdPartyApiAutoConfiguration;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.ApiPropertiesJpaRepository;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.converter.ApiPropertiesJpaEntityConverter;
import cn.shishuihao.thirdparty.api.spring.boot.jpa.repository.ApiPropertiesEntityJpaRepository;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
@EnableJpaRepositories(basePackages =
        "cn.shishuihao.thirdparty.api.spring.boot.jpa.repository")
@AutoConfigureBefore(ThirdPartyApiAutoConfiguration.class)
public class ThirdPartyApiJpaAutoConfiguration {
    /**
     * ApiPropertiesJpaEntityConverter.
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
     * @param jpaRepository jpaRepository
     * @param converter     converter
     * @return ApiPropertiesRepository
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesRepository propertiesRepository(
            final ApiPropertiesEntityJpaRepository jpaRepository,
            final ApiPropertiesJpaEntityConverter converter) {
        return new ApiPropertiesJpaRepository(jpaRepository, converter);
    }
}
