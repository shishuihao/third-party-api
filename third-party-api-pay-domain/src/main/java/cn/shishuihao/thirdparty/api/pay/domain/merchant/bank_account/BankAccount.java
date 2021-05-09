package cn.shishuihao.thirdparty.api.pay.domain.merchant.bank_account;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * 结算账户.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@SuperBuilder
@Data
public class BankAccount {
    /**
     * 账户类型.
     */
    private final BankAccountType type;
    /**
     * 开户名称.
     * 1、选择“经营者个人银行卡”时，开户名称必须与“经营者证件姓名”一致。
     * 2、选择“对公银行账户”时，开户名称必须与营业执照/登记证书的“商户名称”一致。
     */
    private final String name;
    /**
     * 开户银行.
     */
    private final String bank;
    /**
     * 开户银行省市编码.
     * 至少精确到市
     */
    private final String bankAddressCode;
    /**
     * 开户银行联行号.
     */
    private final String bankBranchId;
    /**
     * 开户银行全称（含支行）.
     */
    private final String bankName;
    /**
     * 银行帐号.
     */
    private final String number;
}
