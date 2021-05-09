package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject;

import cn.shishuihao.thirdparty.api.pay.domain.merchant.bank_account.BankAccount;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.certificate.BusinessLicense;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 个体户.
 * 营业执照上的主体类型一般为个体户、个体工商户、个体经营；
 *
 * @author shishuihao
 * @version 1.0.0
 */
@ToString(callSuper = true)
@SuperBuilder
public class Individual extends Subject<
        BusinessLicense,
        BankAccount> {

    /**
     * 主体类型.
     *
     * @return SubjectType
     */
    @Override
    public SubjectType getSubjectType() {
        return SubjectType.INDIVIDUAL;
    }
}
