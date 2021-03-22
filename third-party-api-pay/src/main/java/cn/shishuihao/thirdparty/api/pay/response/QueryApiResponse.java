package cn.shishuihao.thirdparty.api.pay.response;

import cn.shishuihao.thirdparty.api.core.response.BaseApiResponse;
import cn.shishuihao.thirdparty.api.pay.PayApiResponse;
import cn.shishuihao.thirdparty.api.pay.domain.order.OrderStatus;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
public class QueryApiResponse
        extends BaseApiResponse
        implements PayApiResponse {
    /**
     * order status
     */
    private final OrderStatus status;
}
