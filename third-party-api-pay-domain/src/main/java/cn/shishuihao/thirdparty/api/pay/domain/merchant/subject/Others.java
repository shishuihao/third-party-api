package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject;

import cn.shishuihao.thirdparty.api.pay.domain.merchant.bank_account.CorporateBankAccount;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.certificate.Certificate;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.organization.Organization;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 其他组织.
 * 不属于企业、政府/事业单位的组织机构（如社会团体、民办非企业、基金会），要求机构已办理组织机构代码证。
 *
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Data
public class Others extends Subject<
        Certificate,
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
        return SubjectType.OTHERS;
    }
}
