package cn.shishuihao.thirdparty.api.pay.domain.merchant.bank_account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class BankAccountTest {
    @Test
    void test() {
        CorporateBankAccount corporateBankAccount = CorporateBankAccount.builder()
                .name("开户名称")
                .bank("工商银行")
                .bankAddressCode("110000")
                .bankBranchId("402713354941")
                .bankName("施秉县农村信用合作联社城关信用社")
                .number("银行账号")
                .build();
        Assertions.assertEquals(BankAccountType.CORPORATE, corporateBankAccount.getType());
        PersonalBankAccount personalBankAccount = PersonalBankAccount.builder()
                .name("开户名称")
                .bank("工商银行")
                .bankAddressCode("110000")
                .bankBranchId("402713354941")
                .bankName("施秉县农村信用合作联社城关信用社")
                .number("银行账号")
                .build();
        Assertions.assertEquals(BankAccountType.PERSONAL, personalBankAccount.getType());
    }
}