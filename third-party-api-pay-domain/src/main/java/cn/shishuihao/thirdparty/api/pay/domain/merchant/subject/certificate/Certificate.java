package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.certificate;

import cn.shishuihao.thirdparty.api.pay.domain.common.period.Period;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * 登记证书.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@SuperBuilder
@Data
public class Certificate {
    /**
     * 登记证书类型.
     */
    private final CertificateType type;
    /**
     * 登记证书照片.
     */
    private final String copy;
    /**
     * 证书号.
     */
    private final String number;
    /**
     * 商户名称.
     */
    private final String merchantName;
    /**
     * 法人姓名.
     */
    private final String legalPerson;
    /**
     * 注册地址.
     */
    private final String companyAddress;
    /**
     * 有效期限.
     */
    private final Period period;
}
