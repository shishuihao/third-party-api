package cn.shishuihao.thirdparty.api.pay.domain.merchant.bank_account_info;

import lombok.experimental.SuperBuilder;

/**
 * 经营者个人银行卡.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@SuperBuilder
public class PersonalBankAccountInfo extends BankAccountInfo {
    /**
     * 账户类型.
     *
     * @return BankAccountType
     */
    @Override
    public BankAccountType getBankAccountType() {
        return BankAccountType.PERSONAL;
    }
}
