package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject;

import cn.shishuihao.thirdparty.api.pay.domain.merchant.bank_account.BankAccount;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.certificate.Certificate;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.identity_document.IdentityDocument;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * 主体信息.
 *
 * @param <C> 登记证书
 * @param <A> 结算账户
 * @author shishuihao
 * @version 1.0.0
 */
@SuperBuilder
@Data
public class Subject<
        C extends Certificate,
        A extends BankAccount> {
    /**
     * 主体类型.
     */
    private final SubjectType subjectType;
    /**
     * 登记证书.
     */
    private final C certificate;
    /**
     * 经营者/法人身份证件.
     */
    private final IdentityDocument identityDocument;
    /**
     * 结算账户.
     */
    private final A bankAccount;
}
