package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject;

import lombok.Builder;
import lombok.Data;

/**
 * 其他组织.
 * 不属于企业、政府/事业单位的组织机构（如社会团体、民办非企业、基金会），要求机构已办理组织机构代码证。
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Builder
@Data
public class Others implements Subject {
}
