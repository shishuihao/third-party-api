package cn.shishuihao.thirdparty.api.pay.alipay;

import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import com.alipay.easysdk.kernel.AlipayConstants;
import com.alipay.easysdk.kernel.Client;
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
    private final AlipayPayProperties channelProperties;
    private final Map<AlipayPayApiProperties, com.alipay.easysdk.payment.facetoface.Client> clientMap = new ConcurrentHashMap<>();

    public AlipayPayClient(AlipayPayProperties channelProperties) {
        this.channelProperties = channelProperties;
    }

    public com.alipay.easysdk.payment.facetoface.Client getFaceToFaceClient(AlipayPayApiProperties properties) {
        return clientMap.computeIfAbsent(properties, p -> {
            try {
                Config config = new Config();
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
                Context context = new Context(config, SDK_VERSION);
                if (AlipayConstants.AliyunKMS.equals(context.getConfig(AlipayConstants.SIGN_PROVIDER_CONFIG_KEY))) {
                    context.setSigner(new AliyunKMSSigner(new AliyunKMSClient(TeaModel.buildMap(config))));
                }
                return new com.alipay.easysdk.payment.facetoface.Client(new Client(context));
            } catch (Exception e) {
                throw new ApiException(e);
            }
        });
    }
}
