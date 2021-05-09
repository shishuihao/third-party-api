package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject_info.certificate_info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * 营业执照.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class BusinessLicenseInfo extends CertificateInfo {
}
