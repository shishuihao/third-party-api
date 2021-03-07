package cn.shishuihao.thirdparty.api.sms.aliyun;

import cn.shishuihao.thirdparty.api.core.properties.AbstractApiProperties;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.teaopenapi.models.Config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSmsClient {
    /**
     * map.
     */
    private final Map<AbstractApiProperties, Client> map
            = new ConcurrentHashMap<>();

    /**
     * get aliyun sms client.
     *
     * @param properties properties
     * @return Client
     */
    public Client getAliYunClient(final AliYunSmsApiProperties properties) {
        return map.computeIfAbsent(properties, k -> {
            Config config = new Config()
                    .setAccessKeyId(properties.getAccessKeyId())
                    .setAccessKeySecret(properties.getAccessSecret());
            config.setEndpoint(AliYunSmsApiChannel.ENDPOINT);
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
