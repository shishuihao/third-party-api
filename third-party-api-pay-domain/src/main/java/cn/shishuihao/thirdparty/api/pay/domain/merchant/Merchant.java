package cn.shishuihao.thirdparty.api.pay.domain.merchant;

import cn.shishuihao.thirdparty.api.pay.domain.merchant.addition.Addition;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.business_info.BusinessInfo;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.contact.Contact;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.settlement_info.SettlementInfo;
import cn.shishuihao.thirdparty.api.pay.domain.merchant.subject.Subject;
import lombok.Builder;
import lombok.Data;

/**
 * 商户.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Builder
@Data
public class Merchant {
    /**
     * 商户ID.
     */
    private final MerchantId merchantId;
    /**
     * 联系人.
     */
    private final Contact contact;
    /**
     * 主体资料.
     */
    private final Subject<?, ?> subject;
    /**
     * 经营信息.
     */
    private final BusinessInfo businessInfo;
    /**
     * 结算规则.
     */
    private final SettlementInfo settlementInfo;
    /**
     * 补充材料.
     */
    private final Addition addition;
}
