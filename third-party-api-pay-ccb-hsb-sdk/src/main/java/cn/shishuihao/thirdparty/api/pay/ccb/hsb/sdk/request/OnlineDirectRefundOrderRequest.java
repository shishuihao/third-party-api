package cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * 这个接口用于让客户发起退款请求。
 * 尤其是在部分退款时，客户需要明确告知退款金额的出资方，如果该笔退款涉及消费券和红包减项，也需要明确说明具体金额。
 * 客户可以通过此接口发起退款，退款最长期限一般为155天.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
public class OnlineDirectRefundOrderRequest extends AbstractRequest {
    /**
     * 客户方退款流水号.
     * VarChar2 40
     * 非必输
     * 该字段由发起方生成，请求退款时不允许重复
     * （当出现请求超时情况时，客户可凭借此字段重复发起退款，对于同一笔客户方退款流水号，惠市宝确保只发生一次退款）。
     * 重复流水号可查询该流水号退款请求结果；
     * 不同流水号为发起新请求。
     */
    @JsonProperty("Cust_Rfnd_Trcno")
    private final String customerRefundTransactionNo;
    /**
     * 支付流水号.
     * VarChar2 40
     * 必输
     **/
    @JsonProperty("Py_Trn_No")
    private final String payTransactionNo;
    /**
     * 退款金额.
     * NUMBER 19,2
     * 非必输
     * 订单全额退款时不需要送
     * 订单部分退款时必须送此值，且值等于所有子订单的退款金额之和
     **/
    @JsonProperty("Rfnd_Amt")
    private final String refundAmount;
    /**
     * 子订单列表.
     * 主订单全额退款时不需要传该域
     **/
    @JsonProperty("Sub_Ordr_List")
    private final List<Order> orderList;

    @AllArgsConstructor
    @Getter
    @Builder
    public static final class Order {
        /**
         * 子订单编号.
         * VarChar2 40
         * 必输
         * 惠市宝生成的子订单编号
         **/
        @JsonProperty("Sub_Ordr_Id")
        private final String subOrderId;
        /**
         * 退款金额.
         * NUMBER 19,2
         * 必输
         * 子订单总退款金额
         **/
        @JsonProperty("Rfnd_Amt")
        private final String refundAmount;
        /**
         * 分账方列表.
         **/
        @JsonProperty("Parlist")
        private final List<Party> parList;
        /**
         * 消费券列表.
         **/
        @JsonProperty("Cpnlist")
        private final List<Coupon> couponList;
        /**
         * 附加项列表.
         **/
        @JsonProperty("Prjlist")
        private final List<Project> projectList;
    }

    @AllArgsConstructor
    @Getter
    @Builder
    public static final class Party {
        /**
         * 商家编号.
         * VarChar2 30
         * 必输
         **/
        @JsonProperty("Mkt_Mrch_Id")
        private final String marketMerchantId;
        /**
         * 退款金额.
         * NUMBER 19,8
         * 必输
         **/
        @JsonProperty("Rfnd_Amt")
        private final String refundAmount;
    }

    @AllArgsConstructor
    @Getter
    @Builder
    public static final class Coupon {
        /**
         * 消费券订单编号.
         * NUMBER 40
         * 必输
         **/
        @JsonProperty("Cnsmp_Note_Ordr_Id")
        private final String cnsmpNoteOrderId;
        /**
         * 退款金额.
         * NUMBER 19,8
         * 必输
         **/
        @JsonProperty("Rfnd_Amt")
        private final String refundAmount;
    }

    @AllArgsConstructor
    @Getter
    @Builder
    public static final class Project {
        /**
         * 项目编号.
         * VarChar2 120
         * 必输
         **/
        @JsonProperty("Prj_Id")
        private final String projectId;
        /**
         * 退款金额.
         * NUMBER 19,8
         * 必输
         **/
        @JsonProperty("Rfnd_Amt")
        private final String refundAmount;
    }
}
