package cn.shishuihao.thirdparty.api.pay.spring.boot.jpa.autoconfigure;

import cn.shishuihao.thirdparty.api.pay.spring.boot.jpa.domain.transaction.TransactionEntityJpaRepository;
import cn.shishuihao.thirdparty.api.pay.spring.boot.jpa.domain.transaction.TransactionJpaEntityConverter;
import cn.shishuihao.thirdparty.api.pay.spring.boot.jpa.domain.transaction.TransactionJpaRepository;
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
        name = "third-party-api.pay.jpa.enabled",
        matchIfMissing = true)
@EntityScan(basePackages =
        "cn.shishuihao.thirdparty.api.pay.spring.boot.jpa.domain")
@EnableJpaRepositories(basePackages =
        "cn.shishuihao.thirdparty.api.pay.spring.boot.jpa.domain")
@AutoConfigureBefore(ThirdPartyApiStarterAutoConfiguration.class)
public class ThirdPartyApiPayJpaAutoConfiguration {
    /**
     * transactionJpaEntityConverter.
     *
     * @return TransactionJpaEntityConverter
     */
    @Bean
    @ConditionalOnMissingBean
    protected TransactionJpaEntityConverter
    transactionJpaEntityConverter() {
        return new TransactionJpaEntityConverter();
    }

    /**
     * transactionJpaRepository.
     *
     * @param repository repository
     * @param converter  converter
     * @return TransactionJpaRepository
     */
    @Bean
    @ConditionalOnMissingBean
    protected TransactionJpaRepository transactionJpaRepository(
            final TransactionEntityJpaRepository repository,
            final TransactionJpaEntityConverter converter) {
        return new TransactionJpaRepository(repository, converter);
    }
}
