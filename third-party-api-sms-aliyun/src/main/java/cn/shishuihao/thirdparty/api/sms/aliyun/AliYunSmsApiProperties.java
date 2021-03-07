package cn.shishuihao.thirdparty.api.sms.aliyun;

import cn.shishuihao.thirdparty.api.sms.properties.AbstractSmsApiProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(of = {"accessKeyId"}, callSuper = true)
@Getter
@Setter
public class AliYunSmsApiProperties extends AbstractSmsApiProperties {
    /**
     * AccessKeyId用于标识用户.
     */
    private String accessKeyId;
    /**
     * AccessKeySecret是用来验证用户的密钥.
     * AccessKeySecret必须保密。
     */
    private String accessSecret;
    /**
     * 短信签名名称.
     * 请在控制台国内消息或国际/港澳台消息页面中的签名管理页签下签名名称一列查看。
     * 说明 必须是已添加、并通过审核的短信签名。
     */
    private String signName;
    /**
     * 上行短信扩展码.
     * 上行短信，指发送给通信服务提供商的短信，用于定制某种服务、完成查询，
     * 或是办理某种业务等，需要收费的，按运营商普通短信资费进行扣费。
     * 说明 无特殊需要此字段的用户请忽略此字段。
     */
    private String smsUpExtendCode;

    /**
     * new AliYunSmsApiProperties.
     */
    public AliYunSmsApiProperties() {
        this.setChannelId(AliYunSmsApiChannel.CHANNEL_ID);
    }

    /**
     * get entity id.
     *
     * @return entity id
     */
    @Override
    public String id() {
        return accessKeyId;
    }
}
