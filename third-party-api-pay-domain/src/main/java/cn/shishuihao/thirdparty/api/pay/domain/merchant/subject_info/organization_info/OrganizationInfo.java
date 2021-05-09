package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject_info.organization_info;

import cn.shishuihao.thirdparty.api.pay.domain.common.period.Period;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * 组织机构代码证.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@SuperBuilder
@Data
public class OrganizationInfo {
    /**
     * 组织机构代码证照片.
     */
    private final String copy;
    /**
     * 组织机构代码.
     */
    private final String code;
    /**
     * 组织机构代码证有效期.
     */
    private final Period period;
}
