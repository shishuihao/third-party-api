package cn.shishuihao.thirdparty.api.pay.domain.merchant.subject;

import lombok.Builder;
import lombok.Data;

/**
 * 个体户.
 * 营业执照上的主体类型一般为个体户、个体工商户、个体经营；
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Builder
@Data
public class Individual implements Subject {
}
