package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.sms.aliyun;

import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiChannelProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "third-party-api.sms.aliyun")
public class ThirdPartyApiSmsAliyunProperties
        extends AliYunSmsApiChannelProperties {
}
