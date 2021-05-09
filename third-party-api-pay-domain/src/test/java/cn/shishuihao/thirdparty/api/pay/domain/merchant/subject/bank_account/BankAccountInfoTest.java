package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.bank_account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class BankAccountInfoTest {
    @Test
    void test() {
        CorporateBankAccountInfo corporateBankAccountInfo = new CorporateBankAccountInfo(
                BankAccountInfo.builder()
                        .accountName("开户名称")
                        .accountBank("工商银行")
                        .bankAddressCode("110000")
                        .bankBranchId("402713354941")
                        .bankName("施秉县农村信用合作联社城关信用社")
                        .accountNumber("银行账号"));
        Assertions.assertEquals(BankAccountType.CORPORATE, corporateBankAccountInfo.getBankAccountType());
        PersonalBankAccountInfo personalBankAccountInfo = new PersonalBankAccountInfo(
                BankAccountInfo.builder()
                        .accountName("开户名称")
                        .accountBank("工商银行")
                        .bankAddressCode("110000")
                        .bankBranchId("402713354941")
                        .bankName("施秉县农村信用合作联社城关信用社")
                        .accountNumber("银行账号"));
        Assertions.assertEquals(BankAccountType.PERSONAL, personalBankAccountInfo.getBankAccountType());
    }
}