package cn.shishuihao.thirdparty.api.sms.aliyun;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.teaopenapi.models.Config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSmsClient {
    private final AliYunSmsProperties channelProperties;
    private final Map<AliYunSmsApiProperties, Client> map = new ConcurrentHashMap<>();

    public AliYunSmsClient(AliYunSmsProperties channelProperties) {
        this.channelProperties = channelProperties;
    }

    public Client getAliYunClient(AliYunSmsApiProperties properties) {
        return map.computeIfAbsent(properties, k -> {
            Config config = new Config()
                    .setAccessKeyId(k.getAccessKeyId())
                    .setAccessKeySecret(k.getAccessSecret());
            config.setEndpoint(channelProperties.getEndpoint());
            try {
                return new Client(config);
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        });
    }
}
