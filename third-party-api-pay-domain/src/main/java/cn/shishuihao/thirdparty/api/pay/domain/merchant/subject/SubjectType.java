package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject;

/**
 * 主体类型.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public enum SubjectType {
    /**
     * 个体户.
     * {@link Individual}
     */
    INDIVIDUAL,
    /**
     * 企业.
     * {@link Enterprise}
     */
    ENTERPRISE,
    /**
     * 党政、机关及事业单位.
     * {@link Institutions}
     */
    INSTITUTIONS,
    /**
     * 其他组织.
     * {@link Others}
     */
    OTHERS;
}
