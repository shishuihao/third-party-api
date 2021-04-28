package cn.shishuihao.thirdparty.api.pay.chinaums.sdk;

import cn.shishuihao.thirdparty.api.commons.ssl.KeyStoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(of = {
        "appId"
}, callSuper = true)
@Getter
@Setter
public class ChinaumnProperties extends KeyStoreProperties {
    /**
     * 产品ID，由银联商务方提供.
     */
    private String appId;
    /**
     * 产品密钥，由银联商务方提供.
     */
    private String appKey;
    /**
     * 消息ID， 原样返回 字符串 ⇐64 否.
     */
    private String msgId;
    /**
     * 商户号 字符串 8..32 是.
     */
    private String mid;
    /**
     * 终端号 字符串 2..32 是.
     */
    private String tid;
    /**
     * 微信子商户appId 字符串 ⇐32 是.
     */
    private String subAppId;
    /**
     * 机构商户 号 字符串 8..32 是.
     */
    private String instMid;
    /**
     * 消息来源.
     */
    private String msgSrc;
    /**
     * 消息来源ID.
     */
    private String msgSrcId;
    /**
     * 密钥.
     */
    private String key;
}
