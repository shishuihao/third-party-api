package cn.shishuihao.thirdparty.api.push.spring.boot.autoconfigure;

import cn.shishuihao.thirdparty.api.push.spring.boot.controller.ThirdPartyApiPushController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Import({ThirdPartyApiPushController.class})
@Configuration
@ConditionalOnProperty(
        name = "third-party-api.push.enabled",
        matchIfMissing = true)
public class ThirdPartyApiPushAutoConfiguration {
}
