package cn.shishuihao.thirdparty.api.pay.alipay;

import cn.shishuihao.thirdparty.api.core.properties.AbstractApiProperties;
import com.alipay.easysdk.kernel.AlipayConstants;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.kernel.Context;
import com.alipay.easysdk.kms.aliyun.AliyunKMSClient;
import com.alipay.easysdk.kms.aliyun.AliyunKMSSigner;
import com.aliyun.tea.TeaModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.alipay.easysdk.factory.Factory.SDK_VERSION;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AlipayPayClient {
    /**
     * Client Map.
     */
    private final Map<AbstractApiProperties,
            com.alipay.easysdk.kernel.Client> clientMap
            = new ConcurrentHashMap<>();
    /**
     * common Client Map.
     */
    private final Map<AbstractApiProperties,
            com.alipay.easysdk.payment.common.Client> commonClientMap
            = new ConcurrentHashMap<>();
    /**
     * face to face Client Map.
     */
    private final Map<AbstractApiProperties,
            com.alipay.easysdk.payment.facetoface.Client> ftfClientMap
            = new ConcurrentHashMap<>();
    /**
     * app Client Map.
     */
    private final Map<AbstractApiProperties,
            com.alipay.easysdk.payment.app.Client> appClientMap
            = new ConcurrentHashMap<>();
    /**
     * page Client Map.
     */
    private final Map<AbstractApiProperties,
            com.alipay.easysdk.payment.page.Client> pageClientMap
            = new ConcurrentHashMap<>();
    /**
     * wap Client Map.
     */
    private final Map<AbstractApiProperties,
            com.alipay.easysdk.payment.wap.Client> wapClientMap
            = new ConcurrentHashMap<>();

    /**
     * get common Client.
     *
     * @param properties properties
     * @return Client
     */
    public com.alipay.easysdk.payment.common.Client
    getCommonClient(final AlipayPayApiProperties properties) {
        return commonClientMap.computeIfAbsent(properties, k -> rethrow(() ->
                new com.alipay.easysdk.payment.common.Client(
                        this.getClient(properties))));
    }

    /**
     * get face to face Client.
     *
     * @param properties properties
     * @return Client
     */
    public com.alipay.easysdk.payment.facetoface.Client
    getFaceToFaceClient(final AlipayPayApiProperties properties) {
        return ftfClientMap.computeIfAbsent(properties, k -> rethrow(() ->
                new com.alipay.easysdk.payment.facetoface.Client(
                        this.getClient(properties))));
    }

    /**
     * get app Client.
     *
     * @param properties properties
     * @return Client
     */
    public com.alipay.easysdk.payment.app.Client
    getAppClient(final AlipayPayApiProperties properties) {
        return appClientMap.computeIfAbsent(properties, k -> rethrow(() ->
                new com.alipay.easysdk.payment.app.Client(
                        this.getClient(properties))));
    }

    /**
     * get wap Client.
     *
     * @param properties properties
     * @return Client
     */
    public com.alipay.easysdk.payment.wap.Client
    getWapClient(final AlipayPayApiProperties properties) {
        return wapClientMap.computeIfAbsent(properties, k -> rethrow(() ->
                new com.alipay.easysdk.payment.wap.Client(
                        this.getClient(properties))));
    }

    /**
     * get page Client.
     *
     * @param properties properties
     * @return Client
     */
    public com.alipay.easysdk.payment.page.Client
    getPageClient(final AlipayPayApiProperties properties) {
        return pageClientMap.computeIfAbsent(properties, k -> rethrow(() ->
                new com.alipay.easysdk.payment.page.Client(
                        this.getClient(properties))));
    }

    /**
     * get Client.
     *
     * @param properties properties
     * @return Client
     */
    private com.alipay.easysdk.kernel.Client
    getClient(final AlipayPayApiProperties properties) {
        return clientMap.computeIfAbsent(properties, k -> rethrow(() -> {
            final Config config = getConfig(properties);
            final Context context = new Context(config, SDK_VERSION);
            if (AlipayConstants.AliyunKMS.equals(context
                    .getConfig(AlipayConstants.SIGN_PROVIDER_CONFIG_KEY))) {
                context.setSigner(new AliyunKMSSigner(new AliyunKMSClient(
                        TeaModel.buildMap(config))));
            }
            return new com.alipay.easysdk.kernel.Client(context);
        }));
    }

    private <T, E extends Exception> T rethrow(
            final ThrowableSupplier<T, E> supplier) {
        try {
            return supplier.get();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Config getConfig(final AlipayPayApiProperties properties) {
        final Config config = new Config();
        config.protocol = properties.getProtocol();
        config.gatewayHost = properties.getGatewayHost();
        config.appId = properties.getAppId();
        config.signType = properties.getSignType();
        config.alipayPublicKey = properties.getAlipayPublicKey();
        config.merchantPrivateKey = properties.getMerchantPrivateKey();
        config.merchantCertPath = properties.getMerchantCertPath();
        config.alipayCertPath = properties.getAlipayCertPath();
        config.alipayRootCertPath = properties.getAlipayRootCertPath();
        config.notifyUrl = properties.getNotifyUrl();
        config.encryptKey = properties.getEncryptKey();
        config.signProvider = properties.getSignProvider();
        config.httpProxy = properties.getHttpProxy();
        return config;
    }

    @FunctionalInterface
    public interface ThrowableSupplier<T, E extends Exception> {
        /**
         * Gets a result.
         *
         * @return a result
         * @throws E exception
         */
        T get() throws E;
    }
}
