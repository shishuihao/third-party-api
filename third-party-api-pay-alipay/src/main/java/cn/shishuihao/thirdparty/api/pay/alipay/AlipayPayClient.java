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
    private final Map<AlipayPayApiProperties, com.alipay.easysdk.payment.facetoface.Client> faceToFaceClientMap = new ConcurrentHashMap<>();

    public com.alipay.easysdk.payment.facetoface.Client getFaceToFaceClient(AlipayPayApiProperties properties) {
        return faceToFaceClientMap.computeIfAbsent(properties, k -> {
            try {
                Config config = new Config();
                config.protocol = k.getProtocol();
                config.gatewayHost = k.getGatewayHost();
                config.appId = k.getAppId();
                config.signType = k.getSignType();
                config.alipayPublicKey = k.getAlipayPublicKey();
                config.merchantPrivateKey = k.getMerchantPrivateKey();
                config.merchantCertPath = k.getMerchantCertPath();
                config.alipayCertPath = k.getAlipayCertPath();
                config.alipayRootCertPath = k.getAlipayRootCertPath();
                config.notifyUrl = k.getNotifyUrl();
                config.encryptKey = k.getEncryptKey();
                config.signProvider = k.getSignProvider();
                config.httpProxy = k.getHttpProxy();
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
