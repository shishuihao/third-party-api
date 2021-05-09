package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.bank_account;

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
     * builder.
     *
     * @param builder builder
     */
    public PersonalBankAccountInfo(
            final BankAccountInfoBuilder<?, ?> builder) {
        super(builder.bankAccountType(BankAccountType.PERSONAL));
    }
}
