package cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
public class OnlineDirectGatherPlaceOrderResponse
        extends BaseCcbHsbPayResponse {
    /**
     * 发起方时间戳.
     * VarChar2 23
     * 必输
     */
    @JsonProperty("Ittparty_Tms")
    private String ittPartyTimestamp;
    /**
     * 发起方流水号.
     * VarChar2 32
     * 必输
     */
    @JsonProperty("Ittparty_Jrnl_No")
    private String ittPartyJrnlNo;
    /**
     * 主订单编号.
     * VarChar2 40
     * 必输
     */
    @JsonProperty("Main_Ordr_No")
    private String mainOrderNo;
    /**
     * 支付流水号.
     * VarChar2 40
     * 必输
     */
    @JsonProperty("Py_Trn_No")
    private String payTransactionNo;
    /**
     * 订单编号.
     * VarChar2 40
     * 必输
     */
    @JsonProperty("Prim_Ordr_No")
    private String primOrderNo;
    /**
     * 订单生成时间.
     * CHAR 14
     * 必输
     */
    @JsonProperty("Ordr_Gen_Tm")
    private String orderGenTime;
    /**
     * 订单超时时间.
     * CHAR 14
     * 必输
     */
    @JsonProperty("Ordr_Ovtm_Tm")
    private String orderOverTimeTime;
    /**
     * 收银台URL.
     * VarChar2 300
     * 非必输
     */
    @JsonProperty("Cshdk_Url")
    private String cashierDeskUrl;
    /**
     * 支付URL.
     * VarChar2 300
     * 非必输
     */
    @JsonProperty("Pay_Url")
    private String payUrl;
    /**
     * 支付二维码串.
     * VarChar2 300
     * 非必输
     */
    @JsonProperty("Pay_Qr_Code")
    private String payQrCode;
    /**
     * 返回参数数据.
     * VarChar2 1000
     * 非必输
     */
    @JsonProperty("Rtn_Par_Data")
    private String returnParamData;
    /**
     * 等待时间.
     * （单位  s 秒）
     * VarChar2 2
     * 非必输
     */
    @JsonProperty("Wait_Time")
    private String waitTime;
    /**
     * 订单状态代码.
     * VarChar2 2
     * 必输
     */
    @JsonProperty("Ordr_Stcd")
    private String orderStatusCode;
    /**
     * 子订单列表.
     */
    @JsonProperty("Orderlist")
    private List<Order> orderList;

    @Getter
    @Setter
    public static final class Order {
        /**
         * 客户方子订单编号.
         * VarChar2 40
         * 必输
         **/
        @JsonProperty("Cmdty_Ordr_No")
        private String commodityOrderNo;
        /**
         * 子订单编号.
         * VarChar2 40
         * 必输
         **/
        @JsonProperty("Sub_Ordr_Id")
        private String subOrdrId;
    }
}
