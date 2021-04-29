package cn.shishuihao.thirdparty.api.pay.jdpay.sdk.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * 风控信息.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Builder
@Getter
public class RiskInfo {
    /**
     * 外部商户ID omId String(64) 实际交易商户在银行商户系统中的编号.
     */
    private final String omId;
    /**
     * 外部商户名称 omName String(200) 外部商户名称.
     */
    private final String omName;
    /**
     * 外部商户注册时间 omRt String(30) 合作商户的外部商户的注册成功实践，13位unix时间戳.
     */
    private final String omRt;
    /**
     * 外部商户行业 omType String(20) 合作商户的外部商户的行业见 8.3.
     */
    private final String omType;
    /**
     * 外部商户地址 omAdd String(200) 合作商户的外部商户的地址.
     */
    private final String omAdd;
    /**
     * 代理商ID agentId String(64) 代理商的编号.
     */
    private final String agentId;
    /**
     * 代理商名称 agentName String(200) 代理商的名称.
     */
    private final String agentName;
    /**
     * 企业站ID enterpriseId String(64) 实际交易商户在企业站中的编号.
     */
    private final String enterpriseId;
}
