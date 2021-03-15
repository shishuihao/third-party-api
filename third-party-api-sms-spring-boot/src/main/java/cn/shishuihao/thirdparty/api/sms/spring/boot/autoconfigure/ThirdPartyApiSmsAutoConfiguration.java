package cn.shishuihao.thirdparty.api.sms.spring.boot.autoconfigure;

import cn.shishuihao.thirdparty.api.sms.spring.boot.controller.ThirdPartyApiSmsController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Import({ThirdPartyApiSmsController.class})
@Configuration
@ConditionalOnProperty(
        name = "third-party-api.sms.enabled",
        matchIfMissing = true)
public class ThirdPartyApiSmsAutoConfiguration {
}
