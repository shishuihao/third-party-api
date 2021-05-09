package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject_info.organization_info;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

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
     * 组织机构代码证有效期开始日期.
     */
    private final LocalDate periodBegin;
    /**
     * 组织机构代码证有效期结束日期.
     */
    private final LocalDate periodEnd;
}
