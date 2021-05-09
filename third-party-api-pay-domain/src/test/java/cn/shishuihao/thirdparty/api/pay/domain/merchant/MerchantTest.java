package cn.shishuihao.thirdparty.api.pay.domain.merchant;

import cn.shishuihao.thirdparty.api.pay.domain.common.period.ShortTermPeriod;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.addition.Addition;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.bank_account.CorporateBankAccount;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.business_info.AppSalesScenes;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.business_info.BusinessInfo;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.business_info.StoreSalesScenes;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.business_info.WebSalesScenes;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.contact.Contact;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.settlement_info.SettlementInfo;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.Enterprise;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.SubjectType;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.certificate.BusinessLicense;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.identity_document.IdCard;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.organization.Organization;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class MerchantTest {
    @Test
    void test() {
        Merchant merchant = Merchant.builder()
                .contact(Contact.builder()
                        .name("pVd1HJ6zyvPedmty7/mYNxLMpyOb+tI0pQO/0kjiwfqdfg==")
                        .mobile("pVd1HJ6zyv1z0NVa8MRtelw/wDa4SzfeespQO/0kjiwfqdfg==")
                        .email("pVd1HJ6I0m+Jv1z0NVa8MRtelw/wDa4SzfeespQO/0kjiwfqdfg==")
                        .build())
                .subject(Enterprise.builder()
                        .certificate(BusinessLicense.builder()
                                .copy("47ZC6GC-cuxi-v-4KGprrKhwFNIO4kqg05InE4d2I6_H7I4")
                                .number("123456789012345678")
                                .merchantName("xx科技有限公司")
                                .legalPerson("张三")
                                .build())
                        .organization(Organization.builder()
                                .copy("47ZC6GC-vnrbEny__Ie_An5-tCpqxwFNIO4kqg05InE4d2I6_H7I4")
                                .copy("123456789-A")
                                .period(ShortTermPeriod.builder()
                                        .begin(LocalDate.of(2019, 8, 1))
                                        .end(LocalDate.of(2029, 8, 1))
                                        .build())
                                .build())
                        .identityDocument(IdCard.builder()
                                .copy("jTpGmxUX3FBWVQ5NJTZvlKX_gdU4c0BJqRTvDujqhThn4ReFxikqJ5YW6zFQ")
                                .emblem("jTpGmxUX3FBWVQ5NJTZvlKX_gdU4cTvDujqhThn4ReFxikqJ5YW6zFQ")
                                .name("AOZdYGISxo4y44/Ug4P4TG5xzchG/5IL9DBd+Z0zZXkw==")
                                .number("AOZdYGISxo4y44/UgZ69bdu9X+tfMUJ9dl+Le4P4TG5xzchG/5IL9DBd+Z0zZXkw==")
                                .period(ShortTermPeriod.builder()
                                        .begin(LocalDate.of(2019, 6, 6))
                                        .end(LocalDate.of(2026, 6, 6))
                                        .build())
                                .owner(true)
                                .build())
                        .bankAccount(CorporateBankAccount.builder()
                                .name("AOZdYGISxo4y44/UgZ69bdu9X+tfMUJ9dl+L79Jtt7+I8juwEc4P4TG5xzchG/5IL9DBd+Z0zZXkw==")
                                .bank("工商银行")
                                .bankAddressCode("110000")
                                .bankBranchId("402713354941")
                                .bankName("施秉县农村信用合作联社城关信用社")
                                .number("d+xT+MQCvrLHUVDWv/8MR/dB7TkXM2hcR3WL8sPndjXTd75kPkyjqnoMRrEEaYQE8ZRGYoeorwC+w==")
                                .build())
                        .build())
                .businessInfo(BusinessInfo.builder()
                        .merchantShortname("张三餐饮店")
                        .servicePhone("0758XXXXX")
                        .salesScenes(new HashSet<>(Arrays.asList(
                                StoreSalesScenes.builder()
                                        .storeName("大郎烧饼")
                                        .addressCode("440305")
                                        .storeAddress("xx区xx大厦x层xxxx室")
                                        .entrancePics(new String[]{
                                                "0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCzzhJehHhAZN6BKXQPcs-VvdSo"
                                        })
                                        .indoorPics(new String[]{
                                                "0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4R9FwczhJehHhAZN6BKXQPcs-VvdSo"
                                        })
                                        .appId("1234567890123456")
                                        .build(),
                                AppSalesScenes.builder()
                                        .appId("1234567890123456")
                                        .pics(new String[]{
                                                "ZC6GC-vnrbEny__Ie_An5-tCpqxucuxi-vByf3Gjm7KE53JXvGy9tqZm2XAUf-4KGprrKhpVBD"
                                        })
                                        .build(),
                                WebSalesScenes.builder()
                                        .domain("https://www.domain.com")
                                        .authorisation("47ZC6GC-vnrbEny__Ie_An5-tCpqxucBDIUv0OF4wFNIO4kqg05InE4d2I6_H7I4")
                                        .appId("1234567890123456")
                                        .build()
                        )))
                        .build())
                .settlementInfo(SettlementInfo.builder()
                        .settlementId("719")
                        .qualificationType("餐饮")
                        .qualifications(new String[]{
                                "ZC6GC-vnrbEny__Ie_An5-tCpqxucuxi-vByf3Gjm7KE53JXvGy9tqZm2XAUf-4KGprrKhpVBD"
                        })
                        .build())
                .addition(Addition.builder()
                        .legalPersonCommitment("7ZC6GC-vnrbEny__Ie3JXvGy9tqZm2XAUf-4KGprrKhpVBDIUv0OF4wFNIO4kqg05InE4d2I6_H7I4")
                        .legalPersonVideo("47ZC6GC-vnrbEny__Ie_An5-tCpqxucuxi-v4KGprrKhpVBDIUv0OF4wFNIO4kqg05InE4d2I6_H7I4")
                        .businessAdditionPics(new String[]{
                                "ZC6GC-vnrbEny__Ie_An5-tCp3Gjm7KE53JXvGy9tqZm2XAUf-4KGprrKhpVBD",
                                "ZC6GC-vnrbEny__Ie_An5-tCp3Gjm7KE53JXvGy9tqZm2XAUf-4KGprrKhpVBD"
                        })
                        .businessAdditionMsg("特殊情况，说明原因")
                        .build())
                .build();
        Assertions.assertEquals(SubjectType.ENTERPRISE, merchant.getSubject().getSubjectType());
    }
}