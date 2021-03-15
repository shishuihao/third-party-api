package cn.shishuihao.thirdparty.api.pay.spring.boot.autoconfigure;

import cn.shishuihao.thirdparty.api.pay.spring.boot.controller.ThirdPartyApiPayController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Import({ThirdPartyApiPayController.class})
@Configuration
@ConditionalOnProperty(
        name = "third-party-api.pay.enabled",
        matchIfMissing = true)
public class ThirdPartyApiPayAutoConfiguration {
}
