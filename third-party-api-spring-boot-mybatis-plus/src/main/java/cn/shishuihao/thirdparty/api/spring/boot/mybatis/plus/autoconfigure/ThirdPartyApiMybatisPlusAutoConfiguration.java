package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.autoconfigure;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.domain.ApiConfigurationEntityMybatisPlusMapper;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.domain.ApiConfigurationMybatisPlusEntityConverter;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.domain.ApiConfigurationMybatisPlusRepository;
import cn.shishuihao.thirdparty.api.spring.boot.starter.autoconfigure.ThirdPartyApiStarterAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Import({ThirdPartyApiMybatisPlusApplicationListener.class})
@Configuration
@ConditionalOnProperty(
        name = "third-party-api.mybatis-plus.enabled",
        matchIfMissing = true)
@MapperScan(basePackages =
        "cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.domain")
@AutoConfigureBefore(ThirdPartyApiStarterAutoConfiguration.class)
public class ThirdPartyApiMybatisPlusAutoConfiguration {
    /**
     * apiConfigurationMybatisPlusEntityConverter.
     *
     * @return ApiConfigurationMybatisPlusEntityConverter
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiConfigurationMybatisPlusEntityConverter
    apiConfigurationMybatisPlusEntityConverter() {
        return new ApiConfigurationMybatisPlusEntityConverter();
    }

    /**
     * apiConfigurationRepository.
     *
     * @param mapper    mapper
     * @param converter converter
     * @return ApiConfigurationRepository
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiConfigurationRepository apiConfigurationRepository(
            final ApiConfigurationEntityMybatisPlusMapper mapper,
            final ApiConfigurationMybatisPlusEntityConverter converter) {
        return new ApiConfigurationMybatisPlusRepository(mapper, converter);
    }
}
