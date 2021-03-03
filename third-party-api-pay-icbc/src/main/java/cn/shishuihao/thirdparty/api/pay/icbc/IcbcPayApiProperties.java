package cn.shishuihao.thirdparty.api.pay.icbc;

import cn.shishuihao.thirdparty.api.core.properties.AbstractApiProperties;
import cn.shishuihao.thirdparty.api.pay.PayApiProperties;

import java.util.Objects;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class IcbcPayApiProperties extends AbstractApiProperties implements PayApiProperties {
    /**
     * APP的编号,应用在API开放平台注册时生成
     */
    private String appId;
    private String merId;
    private String privateKey;
    /**
     * 签名类型，本接口为RSA2-RSAWithSha256认证方式	RSA2
     */
    private String signType = "RSA2";
    /**
     * 字符集 ,缺省为UTF-8
     */
    private String charset = "UTF-8";
    /**
     * 请求参数格式，仅支持json
     */
    private String format = "json";
    private String icbcPublicKey;
    private String encryptKey;
    private String encryptType;
    private String ca;
    private String password;
    private String emSignIp;
    private String emSignPort;
    private String emProduct;
    public IcbcPayApiProperties() {
        this.setChannelId(IcbcPayApiChannel.CHANNEL_ID);
    }

    @Override
    public String id() {
        return appId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        IcbcPayApiProperties that = (IcbcPayApiProperties) o;
        return Objects.equals(appId, that.appId) && Objects.equals(merId, that.merId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), appId, merId);
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMerId() {
        return merId;
    }

    public void setMerId(String merId) {
        this.merId = merId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getIcbcPublicKey() {
        return icbcPublicKey;
    }

    public void setIcbcPublicKey(String icbcPublicKey) {
        this.icbcPublicKey = icbcPublicKey;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public String getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType;
    }

    public String getCa() {
        return ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmSignIp() {
        return emSignIp;
    }

    public void setEmSignIp(String emSignIp) {
        this.emSignIp = emSignIp;
    }

    public String getEmSignPort() {
        return emSignPort;
    }

    public void setEmSignPort(String emSignPort) {
        this.emSignPort = emSignPort;
    }

    public String getEmProduct() {
        return emProduct;
    }

    public void setEmProduct(String emProduct) {
        this.emProduct = emProduct;
    }
}
