package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject_info;

import lombok.Builder;
import lombok.Data;

/**
 * 营业执照.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Builder
@Data
public class BusinessLicenseInfo {
    /**
     * 营业执照照片.
     */
    private final String licenseCopy;
    /**
     * 注册号/统一社会信用代码.
     */
    private final String licenseNumber;
    /**
     * 商户名称.
     */
    private final String merchantName;
    /**
     * 个体户经营者/法人姓名.
     */
    private final String legalPerson;
}
