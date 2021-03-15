package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Import({})
@Configuration
@ConditionalOnProperty(
        name = "third-party-api.enabled",
        matchIfMissing = true)
public class ThirdPartyApiAutoConfiguration {
}
