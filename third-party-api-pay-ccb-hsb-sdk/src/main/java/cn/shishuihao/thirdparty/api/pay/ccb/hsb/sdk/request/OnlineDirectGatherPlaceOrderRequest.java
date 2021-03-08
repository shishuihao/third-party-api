package cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * 这个接口用于让客户生成订单信息，是所有交互动作的起点，展现形式是主子订单形式，即一个主订单下面挂多个子订单的形式.
 * 客户可以通过这个接口告诉我们三个关键信息：这笔订单的支付方式、订单金额的成分、订单金额的去向。
 * 这个接口会根据客户选择的支付方式返回相应的支付信息。
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
public class OnlineDirectGatherPlaceOrderRequest extends AbstractRequest {
    /**
     * 主订单编号.
     * VarChar2 40
     * 必输
     **/
    @JsonProperty("Main_Ordr_No")
    private final String mainOrderNo;
    /**
     * 支付方式代码.
     * VarChar2 2
     * 必输
     **/
    @JsonProperty("Pymd_Cd")
    private final String payMethodCode;
    /**
     * 码信息（一维码、二维码）.
     * VarChar2  128 128
     **/
    @JsonProperty("QRCODE")
    private final String qrCode;
    /**
     * 订单类型.
     * VarChar2 2
     * 必输
     **/
    @JsonProperty("Py_Ordr_Tpcd")
    private final String payOrderTypeCode;
    /**
     * 支付结果通知序号.
     * VarChar2 3
     * 非必输
     **/
    @JsonProperty("Py_Rslt_Ntc_Sn")
    private final String payResultNoticeSn;
    /**
     * 银行编码.
     * VarChar2 20
     * 非必输
     **/
    @JsonProperty("Bnk_Cd")
    private final String bankCode;
    /**
     * 操作员号.
     * CHAR 8
     * 非必输
     **/
    @JsonProperty("Opr_No")
    private final String operatorNo;
    /**
     * 用户ID.
     * Char 10
     * 非必输
     **/
    @JsonProperty("Usr_Id")
    private final String userId;
    /**
     * 币种.
     * Char 3
     * 必输
     **/
    @JsonProperty("Ccy")
    private final String currency;
    /**
     * 页面返回URL地址.
     * VarChar2 3000
     * 非必输
     **/
    @JsonProperty("Pgfc_Ret_Url_Adr")
    private final String pageReturnUrlAddress;
    /**
     * 订单总金额.
     * NUMBER 19,2
     * 必输
     **/
    @JsonProperty("Ordr_Tamt")
    private final String orderTotalAmount;
    /**
     * 交易总金额.
     * NUMBER 19,2
     * 必输
     **/
    @JsonProperty("Txn_Tamt")
    private final String transactionTotalAmount;
    /**
     * 小程序的APPID.
     * VarChar2 32
     * 非必输
     **/
    @JsonProperty("Sub_Appid")
    private final String subAppid;
    /**
     * 用户子标识.
     * VarChar2 128
     * 非必输
     **/
    @JsonProperty("Sub_Openid")
    private final String subOpenid;
    /**
     * 分期期数.
     * VarChar2
     * 非必输
     **/
    @JsonProperty("Install_Num")
    private final String installNum;
    /**
     * 手续费承担方编号.
     * VarChar2 30
     * 非必输
     **/
    @JsonProperty("Hdcg_Brs_Id")
    private final String handChargeBearsId;
    /**
     * 确认收货日期.
     * VarChar2 8
     * 非必输
     **/
    @JsonProperty("Clrg_Dt")
    private final String clearGoodsDate;
    /**
     * 支付描述.
     * VarChar 300
     * 非必输
     **/
    @JsonProperty("Pay_Dsc")
    private final String payDesc;
    /**
     * 订单超时时间.
     * VarChar 4
     * 非必输
     **/
    @JsonProperty("Order_Time_Out")
    private final String orderTimeOut;
    /**
     * 子订单列表.
     **/
    @JsonProperty("Orderlist")
    private final List<Order> orderList;

    @AllArgsConstructor
    @Getter
    @Builder
    public static final class Order {
        /**
         * 商家编号.
         * VarChar2 30
         * 必输
         **/
        @JsonProperty("Mkt_Mrch_Id")
        private final String marketMerchantId;
        /**
         * 商家自定义编号.
         * VarChar2 30
         * 非必输
         **/
        @JsonProperty("Udf_Id")
        private final String userDefinedId;
        /**
         * 客户方子订单编号.
         * VarChar2 40
         * 必输
         **/
        @JsonProperty("Cmdty_Ordr_No")
        private final String commodityOrderNo;
        /**
         * 订单金额.
         * NUMBER 19,2
         * 必输
         **/
        @JsonProperty("Ordr_Amt")
        private final String orderAmount;
        /**
         * 交易金额.
         * NUMBER 19,2
         * 必输
         **/
        @JsonProperty("Txnamt")
        private final String transactionAmount;
        /**
         * 附加项总金额.
         * NUMBER 19,2
         * 非必输
         **/
        @JsonProperty("Apd_Tamt")
        private final String apdTotalAmount;
        /**
         * 商品描述.
         * VarChar2 300
         * 非必输
         **/
        @JsonProperty("Cmdty_Dsc")
        private final String commodityDesc;
        /**
         * 商品类型.
         * VarChar2 6
         * 非必输
         **/
        @JsonProperty("Cmdty_Tp")
        private final String commodityType;
        /**
         * 分账规则编号.
         * VarChar2 32
         * 非必输
         **/
        @JsonProperty("Clrg_Rule_Id")
        private final String clrgRuleId;
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
         * 顺序号.
         * NUMBER 10
         * 必输
         **/
        @JsonProperty("Seq_No")
        private final String seqNo;
        /**
         * 商家编号.
         * VarChar2 30
         * 必输
         **/
        @JsonProperty("Mkt_Mrch_Id")
        private final String marketMerchantId;
        /**
         * 金额.
         * NUMBER 19,8
         * 非必输
         **/
        @JsonProperty("Amt")
        private final String amount;
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
         * 金额.
         * NUMBER 19,8
         * 必输
         **/
        @JsonProperty("Amt")
        private final String amount;
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
         * 项目名称.
         * VarChar2 60
         * 必输
         **/
        @JsonProperty("Prj_Nm")
        private final String projectName;
        /**
         * 项目类型.
         * Char 1
         * 必输
         **/
        @JsonProperty("Pjcy_Tp")
        private final String projectType;
        /**
         * 金额.
         * NUMBER 19,8
         * 必输
         **/
        @JsonProperty("Amt")
        private final String amount;
    }
}
