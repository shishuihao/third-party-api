package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.bank_account;

import lombok.experimental.SuperBuilder;

/**
 * 对公银行账户.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@SuperBuilder
public class CorporateBankAccountInfo extends BankAccountInfo {
    /**
     * builder.
     *
     * @param builder builder
     */
    public CorporateBankAccountInfo(
            final BankAccountInfoBuilder<?, ?> builder) {
        super(builder.bankAccountType(BankAccountType.CORPORATE));
    }
}
