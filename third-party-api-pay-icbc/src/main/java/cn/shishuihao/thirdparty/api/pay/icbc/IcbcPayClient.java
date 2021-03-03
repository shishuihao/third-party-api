package cn.shishuihao.thirdparty.api.pay.icbc;

import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import com.icbc.api.DefaultIcbcClient;
import com.icbc.api.IcbcClient;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class IcbcPayClient {
    private final Map<IcbcPayApiProperties, DefaultIcbcClient> clientMap = new ConcurrentHashMap<>();

    public IcbcClient getClient(IcbcPayApiProperties properties) {
        return clientMap.computeIfAbsent(properties, p -> {
            try {
                return new DefaultIcbcClient(
                        properties.getAppId(),
                        properties.getSignType(),
                        properties.getPrivateKey(),
                        properties.getCharset(),
                        properties.getFormat(),
                        properties.getIcbcPublicKey(),
                        Optional.ofNullable(properties.getEncryptType()).orElse(null),
                        properties.getEncryptKey(),
                        properties.getCa(),
                        properties.getPassword());
            } catch (Exception e) {
                throw new ApiException(e);
            }
        });
    }
}
