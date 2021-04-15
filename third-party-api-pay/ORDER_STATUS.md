# 订单状态

-  NEW_ORDER 
-  WAIT_BUYER_PAY     [  可支付，不可关闭，不可撤销，不可退款]交易创建，等待买家付款
-  TRADE_UNKNOWN      [不可支付，  可关闭，  可撤销，不可退款]交易状态未知
-  TRADE_SUCCESS      [不可支付，不可关闭，不可撤销，  可退款]交易支付成功
-  TRADE_FAIL         [  可支付，  可关闭，  可撤销，不可退款]交易支付失败
-  TRADE_REFUND       [不可支付，不可关闭，不可撤销，不可退款]交易已转退款，不可退款
-  TRADE_CLOSED       [不可支付，不可关闭，不可撤销，不可退款]未付款交易超时关闭，或支付完成后全额退款，不可退款

-  REFUND_PROCESSING  [不可退款]退款处理中
-  REFUND_UNKNOWN     [不可退款]退款状态未知
-  REFUND_SUCCESS     [不可退款]退款成功或者全额退款
-  REFUND_PARTIAL     [不可退款]部分退款
-  REFUND_FAIL        [  可退款]退款失败
-  REFUND_CLOSED      [不可退款]退款关闭

|                   |支付宝        |银联商务      |工商银行   |工商银行-融e联|微信       |建设银行|               |建设银行-外联平台|
|  ----             | ---          | ---          | ---       | ----         | ----      | ----   | ----          | ----            |
| 未支付            |              |              |           |              |           |        |               |                 |
| PLACE_FAIL        |              |              |-1:下单失败|              |           |        |               |                 |
| TRADE_NOTPAY      |              |NEW_ORDER     |           |              |NOTPAY     |N       |               |                 |
| 支付中            |              |              |           |              |           |        |               |                 |
| WAIT_BUYER_PAY    |WAIT_BUYER_PAY|WAIT_BUYER_PAY|0：支付中  |0：支付中     |USERPAYING |        |1 待支付       |                 |
| TRADE_UNKNOWN     |              |UNKNOWN       |           |              |           |U       |               |2:待银行确认     |
| 支付成功          |              |              |           |              |           |        |               |                 |
| TRADE_SUCCESS     |TRADE_SUCCESS |TRADE_SUCCESS |1：支付成功|1：支付成功   |SUCCESS    |Y       |2 成功         |1:成功           |
| 支付失败          |              |              |           |              |           |        |               |                 |
| TRADE_FAIL        |              |              |2：支付失败|2：支付失败   |           |        |3 失败         |0:失败           |
| TRADE_PAYERROR    |              |              |           |              |PAYERROR   |        |               |                 |
| 支付完成          |              |              |           |              |           |        |               |                 |
| TRADE_REVOKED     |              |              |           |              |REVOKED    |        |               |                 |
| TRADE_REFUND      |              |TRADE_REFUND  |           |              |REFUND     |        |               |                 |
| TRADE_FINISHED    |TRADE_FINISHED|              |           |              |           |        |               |                 |
| TRADE_CLOSED      |TRADE_CLOSED  |TRADE_CLOSED  |           |              |CLOSED     |        |               |                 |
| 失效              |              |              |           |              |           |        |6 失效         |                 |
| 退款中            |              |              |           |              |           |        |               |                 |
| 待退款            |              |              |           |              |           |        |7 待退款       |                 |
| REFUND_PROCESSING |              |PROCESSING    |           |              |PROCESSING |        |a 待处理       |                 |
| REFUND_UNKNOWN    |              |UNKNOWN      |0：退款可疑 |              |           |        |9 待轮询       |5:待银行确认     |
| 退款成功          |              |              |           |              |           |        |               |                 |
| REFUND_PARTIAL    |REFUND_SUCCESS|              |           |              |           |        |5 部分退款     |3:已部分退款     |
| 已全额退款        |REFUND_CLOSED |              |           |              |           |        |4 全部退款     |4:已全额退款     |
| REFUND_SUCCESS    |REFUND_SUCCESS|SUCCESS       |1：退款成功|1：退货成功   |SUCCESS    |        |               |                 |
| 退款失败          |              |              |           |              |           |        |               |                 |
| REFUND_FAIL       |              |FAIL          |2：退款失败|2：退货失败   |           |        |8 退款失败     |                 |
| REFUND_CHANGE     |              |              |           |              |CHANGE     |        |               |                 |
| 退款完成          |              |              |           |              |           |        |               |                 |
| REFUND_CLOSED     |REFUND_CLOSED |              |           |              |REFUNDCLOSE|        |               |                 |




