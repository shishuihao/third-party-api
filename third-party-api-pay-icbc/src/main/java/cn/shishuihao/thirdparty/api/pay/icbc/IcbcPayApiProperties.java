package cn.shishuihao.thirdparty.api.pay.icbc;

import cn.shishuihao.thirdparty.api.pay.properties.AbstractPayApiProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(of = {"appId", "merId"}, callSuper = true)
@Getter
@Setter
public class IcbcPayApiProperties extends AbstractPayApiProperties {
    /**
     * app id.
     */
    private String appId;
    /**
     * merchant id.
     */
    private String merId;
    /**
     * private key.
     */
    private String privateKey;
    /**
     * sign type.
     */
    private String signType = "RSA2";
    /**
     * charset.
     * 缺省为UTF-8
     */
    private String charset = "UTF-8";
    /**
     * 请求参数格式.
     * 仅支持json
     */
    private String format = "json";
    /**
     * icbc public key.
     */
    private String icbcPublicKey;
    /**
     * encrypt key.
     */
    private String encryptKey;
    /**
     * encrypt type.
     */
    private String encryptType;
    /**
     * ca.
     */
    private String ca;
    /**
     * password.
     */
    private String password;
    /**
     * emSignIp.
     */
    private String emSignIp;
    /**
     * emSignPort.
     */
    private String emSignPort;
    /**
     * emProduct.
     */
    private String emProduct;

    /**
     * new IcbcPayApiProperties.
     */
    public IcbcPayApiProperties() {
        this.setChannelId(IcbcPayApiChannel.CHANNEL_ID);
    }

    /**
     * get entity id.
     *
     * @return entity id
     */
    @Override
    public String id() {
        return String.join(":", appId, merId);
    }
}
