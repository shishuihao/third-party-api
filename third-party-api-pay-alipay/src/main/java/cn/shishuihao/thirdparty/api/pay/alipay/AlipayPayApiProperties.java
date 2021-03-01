package cn.shishuihao.thirdparty.api.pay.alipay;

import cn.shishuihao.thirdparty.api.pay.PayApiProperties;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.Validation;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AlipayPayApiProperties implements PayApiProperties {
    /**
     * channel id
     */
    private String channelId = AlipayPayApiChannel.CHANNEL_ID;
    /**
     * 通信协议，通常填写https
     */
    @NameInMap("protocol")
    @Validation(required = true)
    private String protocol = "https";

    /**
     * 网关域名
     * 线上为：openapi.alipay.com
     * 沙箱为：openapi.alipaydev.com
     */
    @NameInMap("gatewayHost")
    @Validation(required = true)
    private String gatewayHost = "openapi.alipay.com";

    /**
     * AppId
     */
    @NameInMap("appId")
    @Validation(required = true)
    private String appId;

    /**
     * 签名类型，Alipay Easy SDK只推荐使用RSA2，估此处固定填写RSA2
     */
    @NameInMap("signType")
    @Validation(required = true)
    private String signType = "RSA2";

    /**
     * 支付宝公钥
     */
    @NameInMap("alipayPublicKey")
    private String alipayPublicKey;

    /**
     * 应用私钥
     */
    @NameInMap("merchantPrivateKey")
    @Validation(required = true)
    private String merchantPrivateKey;

    /**
     * 应用公钥证书文件路径
     */
    @NameInMap("merchantCertPath")
    private String merchantCertPath;

    /**
     * 支付宝公钥证书文件路径
     */
    @NameInMap("alipayCertPath")
    private String alipayCertPath;

    /**
     * 支付宝根证书文件路径
     */
    @NameInMap("alipayRootCertPath")
    private String alipayRootCertPath;

    /**
     * 异步通知回调地址（可选）
     */
    @NameInMap("notifyUrl")
    private String notifyUrl;

    /**
     * AES密钥（可选）
     */
    @NameInMap("encryptKey")
    private String encryptKey;

    /**
     * 签名提供方的名称(可选)，例：Aliyun KMS签名，signProvider = "AliyunKMS"
     */
    @NameInMap("signProvider")
    private String signProvider;

    /**
     * 代理地址（可选）
     * 例如：http://127.0.0.1:8080
     */
    @NameInMap("httpProxy")
    private String httpProxy;

    /**
     * 忽略证书校验（可选）
     */
    @NameInMap("ignoreSSL")
    private boolean ignoreSSL;

    @Override
    public String channelId() {
        return channelId;
    }

    @Override
    public String id() {
        return appId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }


    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getGatewayHost() {
        return gatewayHost;
    }

    public void setGatewayHost(String gatewayHost) {
        this.gatewayHost = gatewayHost;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getMerchantPrivateKey() {
        return merchantPrivateKey;
    }

    public void setMerchantPrivateKey(String merchantPrivateKey) {
        this.merchantPrivateKey = merchantPrivateKey;
    }

    public String getMerchantCertPath() {
        return merchantCertPath;
    }

    public void setMerchantCertPath(String merchantCertPath) {
        this.merchantCertPath = merchantCertPath;
    }

    public String getAlipayCertPath() {
        return alipayCertPath;
    }

    public void setAlipayCertPath(String alipayCertPath) {
        this.alipayCertPath = alipayCertPath;
    }

    public String getAlipayRootCertPath() {
        return alipayRootCertPath;
    }

    public void setAlipayRootCertPath(String alipayRootCertPath) {
        this.alipayRootCertPath = alipayRootCertPath;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public String getSignProvider() {
        return signProvider;
    }

    public void setSignProvider(String signProvider) {
        this.signProvider = signProvider;
    }

    public String getHttpProxy() {
        return httpProxy;
    }

    public void setHttpProxy(String httpProxy) {
        this.httpProxy = httpProxy;
    }

    public boolean isIgnoreSSL() {
        return ignoreSSL;
    }

    public void setIgnoreSSL(boolean ignoreSSL) {
        this.ignoreSSL = ignoreSSL;
    }
}
