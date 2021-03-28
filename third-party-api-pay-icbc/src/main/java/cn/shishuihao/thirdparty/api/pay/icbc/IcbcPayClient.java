package cn.shishuihao.thirdparty.api.pay.icbc;

import cn.shishuihao.thirdparty.api.core.properties.AbstractApiProperties;
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
    /**
     * map.
     */
    private final Map<AbstractApiProperties, DefaultIcbcClient> map
            = new ConcurrentHashMap<>();

    /**
     * get icbc client bt properties.
     *
     * @param properties properties
     * @return IcbcClient
     */
    public IcbcClient getClient(final IcbcPayApiProperties properties) {
        return map.computeIfAbsent(properties, k -> {
            try {
                return new DefaultIcbcClient(
                        properties.getAppId(),
                        properties.getSignType(),
                        properties.getPrivateKey(),
                        properties.getCharset(),
                        properties.getFormat(),
                        properties.getIcbcPublicKey(),
                        Optional.ofNullable(properties.getEncryptType())
                                .orElse(null),
                        properties.getEncryptKey(),
                        properties.getCa(),
                        properties.getPassword(),
                        properties.getEmSignIp(),
                        properties.getEmSignPort(),
                        properties.getEmProduct());
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        });
    }
}
