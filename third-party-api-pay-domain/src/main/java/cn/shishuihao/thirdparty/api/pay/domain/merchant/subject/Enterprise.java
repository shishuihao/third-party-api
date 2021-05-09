package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject;

import cn.shishuihao.thirdparty.api.pay.domain.merchant.bank_account.CorporateBankAccount;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.certificate.BusinessLicense;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.organization.Organization;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 企业.
 * 营业执照上的主体类型一般为有限公司、有限责任公司；
 *
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Data
public class Enterprise extends Subject<
        BusinessLicense,
        CorporateBankAccount> {
    /**
     * 组织机构代码证.
     */
    private final Organization organization;

    /**
     * 主体类型.
     *
     * @return SubjectType
     */
    @Override
    public SubjectType getSubjectType() {
        return SubjectType.ENTERPRISE;
    }
}
