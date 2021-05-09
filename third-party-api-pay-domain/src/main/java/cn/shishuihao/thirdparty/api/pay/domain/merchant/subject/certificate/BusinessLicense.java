package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.certificate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 营业执照.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Data
public class BusinessLicense extends Certificate {
}
