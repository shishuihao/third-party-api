package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject_info.identity_info;

import cn.shishuihao.thirdparty.api.pay.domain.common.period.Period;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * 经营者/法人身份证件.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@SuperBuilder
@Data
public class IdentityInfo {
    /**
     * 证件类型.
     */
    private final IdentityType idType;
    /**
     * 证件照片.
     */
    private final String copy;
    /**
     * 证件持有人姓名.
     */
    private final String name;
    /**
     * 证件号码.
     */
    private final String number;
    /**
     * 证件有效期.
     */
    private final Period period;
    /**
     * 经营者/法人是否为受益人.
     * 1、若经营者/法人是最终受益人，则填写：true。
     * 2、若经营者/法人不是最终受益人，则填写：false。
     */
    private final boolean owner;
}
