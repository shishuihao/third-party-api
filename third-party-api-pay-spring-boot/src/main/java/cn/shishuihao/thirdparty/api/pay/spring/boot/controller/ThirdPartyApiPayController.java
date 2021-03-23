package cn.shishuihao.thirdparty.api.pay.spring.boot.controller;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.pay.request.AppPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.AppletPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.CancelPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.H5PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.JsApiPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.QueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.RefundQueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.RefundPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.AppPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.AppletPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.CancelPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.H5PayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.JsApiPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.QueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.RefundQueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.RefundPayApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@RequestMapping("/api/v1/pay")
@RestController
public class ThirdPartyApiPayController {
    /**
     * applet pay.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/applet-pay")
    public CompletableFuture<AppletPayApiResponse> appletPay(
            @Valid @RequestBody final AppletPayApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                ApiRegistry.INSTANCE.execute(request));
    }

    /**
     * app pay.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/app-pay")
    public CompletableFuture<AppPayApiResponse> appPay(
            @Valid @RequestBody final AppPayApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                ApiRegistry.INSTANCE.execute(request));
    }

    /**
     * code pay.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/code-pay")
    public CompletableFuture<CodePayApiResponse> codePay(
            @Valid @RequestBody final CodePayApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                ApiRegistry.INSTANCE.execute(request));
    }

    /**
     * h5 pay.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/h5-pay")
    public CompletableFuture<H5PayApiResponse> h5Pay(
            @Valid @RequestBody final H5PayApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                ApiRegistry.INSTANCE.execute(request));
    }

    /**
     * js api pay.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/js-api-pay")
    public CompletableFuture<JsApiPayApiResponse> jsApiPay(
            @Valid @RequestBody final JsApiPayApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                ApiRegistry.INSTANCE.execute(request));
    }

    /**
     * query.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/query")
    public CompletableFuture<QueryPayApiResponse> codePay(
            @Valid @RequestBody final QueryPayApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                ApiRegistry.INSTANCE.execute(request));
    }

    /**
     * cancel.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/cancel")
    public CompletableFuture<CancelPayApiResponse> cancel(
            @Valid @RequestBody final CancelPayApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                ApiRegistry.INSTANCE.execute(request));
    }

    /**
     * refund.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/refund")
    public CompletableFuture<RefundPayApiResponse> refund(
            @Valid @RequestBody final RefundPayApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                ApiRegistry.INSTANCE.execute(request));
    }

    /**
     * refund query.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/refund-query")
    public CompletableFuture<RefundQueryPayApiResponse> refundQuery(
            @Valid @RequestBody final RefundQueryPayApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                ApiRegistry.INSTANCE.execute(request));
    }
}
