package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject;

import cn.shishuihao.thirdparty.api.pay.domain.merchant.bank_account.CorporateBankAccount;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.bank_account.PersonalBankAccount;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.certificate.BusinessLicense;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.certificate.Certificate;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.identity_document.IdCard;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.organization.Organization;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class SubjectTest {
    @Test
    void test() {
        Enterprise enterprise = Enterprise.builder()
                .certificate(BusinessLicense.builder()
                        .build())
                .organization(Organization.builder()
                        .build())
                .identityDocument(IdCard.builder()
                        .build())
                .bankAccount(CorporateBankAccount.builder()
                        .build())
                .build();
        Assertions.assertEquals(SubjectType.ENTERPRISE, enterprise.getSubjectType());
        Individual individual = Individual.builder()
                .certificate(BusinessLicense.builder()
                        .build())
                .identityDocument(IdCard.builder()
                        .build())
                .bankAccount(PersonalBankAccount.builder()
                        .build())
                .build();
        Assertions.assertEquals(SubjectType.INDIVIDUAL, individual.getSubjectType());
        Institutions institutions = Institutions.builder()
                .certificate(Certificate.builder()
                        .build())
                .organization(Organization.builder()
                        .build())
                .identityDocument(IdCard.builder()
                        .build())
                .bankAccount(CorporateBankAccount.builder()
                        .build())
                .build();
        Assertions.assertEquals(SubjectType.INSTITUTIONS, institutions.getSubjectType());
        Others others = Others.builder()
                .certificate(Certificate.builder()
                        .build())
                .organization(Organization.builder()
                        .build())
                .identityDocument(IdCard.builder()
                        .build())
                .bankAccount(CorporateBankAccount.builder()
                        .build())
                .build();
        Assertions.assertEquals(SubjectType.OTHERS, others.getSubjectType());
    }
}