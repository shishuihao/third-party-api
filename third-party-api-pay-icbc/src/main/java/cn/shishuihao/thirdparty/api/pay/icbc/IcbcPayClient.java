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
    private final Map<IcbcPayApiProperties, DefaultIcbcClient> map = new ConcurrentHashMap<>();

    public IcbcClient getClient(IcbcPayApiProperties properties) {
        return map.computeIfAbsent(properties, k -> {
            try {
                return new DefaultIcbcClient(
                        k.getAppId(),
                        k.getSignType(),
                        k.getPrivateKey(),
                        k.getCharset(),
                        k.getFormat(),
                        k.getIcbcPublicKey(),
                        Optional.ofNullable(k.getEncryptType()).orElse(null),
                        k.getEncryptKey(),
                        k.getCa(),
                        k.getPassword());
            } catch (Exception e) {
                throw new ApiException(e);
            }
        });
    }
}
