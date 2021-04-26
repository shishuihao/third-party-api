package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.commons.time.LocalDateUtils;
import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayClient;
import cn.shishuihao.thirdparty.api.pay.alipay.assembler.AlipayPayResponseAssembler;
import cn.shishuihao.thirdparty.api.pay.alipay.domain.AlipayBillType;
import cn.shishuihao.thirdparty.api.pay.api.DownloadBillPayApi;
import cn.shishuihao.thirdparty.api.pay.request.DownloadBillPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.DownloadBillPayApiResponse;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class AlipayDownloadBillPayApi implements DownloadBillPayApi {
    /**
     * alipay pay client.
     */
    private final AlipayPayClient client;

    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public DownloadBillPayApiResponse execute(
            final DownloadBillPayApiRequest request) {
        final AlipayPayApiProperties properties = (AlipayPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            // 账单时间：
            // 日账单格式为yyyy-MM-dd，最早可下载2016年1月1日开始的日账单；
            // 月账单格式为yyyy-MM，最早可下载2016年1月开始的月账单。
            final String billDate = request.getBillDate()
                    .format(LocalDateUtils.DATE_FORMATTER);
            return AlipayPayResponseAssembler.INSTANCE
                    .assemble(client.getCommonClient(properties)
                            .downloadBill(AlipayBillType.TRADE.getValue(),
                                    billDate));
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
