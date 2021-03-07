package cn.shishuihao.thirdparty.api.pay.alipay;

import cn.shishuihao.thirdparty.api.pay.properties.AbstractPayApiProperties;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.Validation;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(of = "appId", callSuper = true)
@Getter
@Setter
public class AlipayPayApiProperties extends AbstractPayApiProperties {
    /**
     * 通信协议，通常填写https.
     */
    @NameInMap("protocol")
    @Validation(required = true)
    private String protocol = "https";
    /**
     * 网关域名.
     * 线上为：openapi.alipay.com
     * 沙箱为：openapi.alipaydev.com
     */
    @NameInMap("gatewayHost")
    @Validation(required = true)
    private String gatewayHost = "openapi.alipay.com";
    /**
     * AppId.
     */
    @NameInMap("appId")
    @Validation(required = true)
    private String appId;
    /**
     * 签名类型.
     * Alipay Easy SDK只推荐使用RSA2，估此处固定填写RSA2.
     */
    @NameInMap("signType")
    @Validation(required = true)
    private String signType = "RSA2";
    /**
     * 支付宝公钥.
     */
    @NameInMap("alipayPublicKey")
    private String alipayPublicKey;
    /**
     * 应用私钥.
     */
    @NameInMap("merchantPrivateKey")
    @Validation(required = true)
    private String merchantPrivateKey;
    /**
     * 应用公钥证书文件路径.
     */
    @NameInMap("merchantCertPath")
    private String merchantCertPath;
    /**
     * 支付宝公钥证书文件路径.
     */
    @NameInMap("alipayCertPath")
    private String alipayCertPath;
    /**
     * 支付宝根证书文件路径.
     */
    @NameInMap("alipayRootCertPath")
    private String alipayRootCertPath;
    /**
     * 异步通知回调地址（可选）.
     */
    @NameInMap("notifyUrl")
    private String notifyUrl;
    /**
     * AES密钥（可选）.
     */
    @NameInMap("encryptKey")
    private String encryptKey;
    /**
     * 签名提供方的名称(可选).
     * 例：Aliyun KMS签名，signProvider = "AliyunKMS".
     */
    @NameInMap("signProvider")
    private String signProvider;
    /**
     * 代理地址（可选）.
     * 例如：http://127.0.0.1:8080
     */
    @NameInMap("httpProxy")
    private String httpProxy;
    /**
     * 忽略证书校验（可选）.
     */
    @NameInMap("ignoreSSL")
    private boolean ignoreSsl;

    /**
     * new AlipayPayApiProperties.
     */
    public AlipayPayApiProperties() {
        this.setChannelId(AlipayPayApiChannel.CHANNEL_ID);
    }

    /**
     * get entity id.
     *
     * @return entity id
     */
    @Override
    public String id() {
        return appId;
    }
}
