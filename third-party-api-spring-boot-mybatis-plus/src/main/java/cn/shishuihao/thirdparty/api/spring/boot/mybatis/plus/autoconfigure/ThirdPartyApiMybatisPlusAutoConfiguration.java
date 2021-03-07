package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.autoconfigure;

import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.ThirdPartyApiAutoConfiguration;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.ApiPropertiesMybatisPlusRepository;
import cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.mapper.ApiPropertiesEntityMybatisPlusMapper;
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
        "cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.mapper")
@AutoConfigureBefore(ThirdPartyApiAutoConfiguration.class)
public class ThirdPartyApiMybatisPlusAutoConfiguration {
    /**
     * propertiesRepository.
     *
     * @param mpMapper mybatisPlusMapper
     * @return ApiPropertiesRepository
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesRepository propertiesRepository(
            final ApiPropertiesEntityMybatisPlusMapper mpMapper) {
        return new ApiPropertiesMybatisPlusRepository(mpMapper);
    }
}
