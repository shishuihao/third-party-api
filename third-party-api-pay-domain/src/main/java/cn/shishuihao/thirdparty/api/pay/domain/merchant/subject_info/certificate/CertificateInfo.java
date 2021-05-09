package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject_info.certificate;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

/**
 * 登记证书.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@SuperBuilder
@Data
public class CertificateInfo {
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
     * 有效期限开始日期.
     */
    private final LocalDate periodBegin;
    /**
     * 有效期限结束日期.
     */
    private final LocalDate periodEnd;
}
