package cn.shishuihao.thirdparty.api.sms.aliyun;

import cn.shishuihao.thirdparty.api.core.exception.ApiException;
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
    private final Map<AliYunSmsApiProperties, Client> clientMap = new ConcurrentHashMap<>();

    public AliYunSmsClient(AliYunSmsProperties channelProperties) {
        this.channelProperties = channelProperties;
    }

    public Client getAliYunClient(AliYunSmsApiProperties properties) {
        return clientMap.computeIfAbsent(properties, p -> {
            Config config = new Config()
                    .setAccessKeyId(p.getAccessKeyId())
                    .setAccessKeySecret(p.getAccessSecret());
            config.setEndpoint(channelProperties.getEndpoint());
            try {
                return new Client(config);
            } catch (Exception e) {
                throw new ApiException(e);
            }
        });
    }
}
