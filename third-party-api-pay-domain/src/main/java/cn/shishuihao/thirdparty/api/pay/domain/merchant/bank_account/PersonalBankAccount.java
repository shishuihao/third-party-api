package cn.shishuihao.thirdparty.api.pay.domain.merchant.bank_account;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 经营者个人银行卡.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@ToString(callSuper = true)
@SuperBuilder
public class PersonalBankAccount extends BankAccount {
    /**
     * 账户类型.
     *
     * @return BankAccountType
     */
    @Override
    public BankAccountType getType() {
        return BankAccountType.PERSONAL;
    }
}
