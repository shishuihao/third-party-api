package cn.shishuihao.thirdparty.api.pay.spring.boot.controller;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.QueryApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.QueryApiResponse;
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
     * query.
     *
     * @param request request
     * @return response
     */
    @PostMapping("/query")
    public CompletableFuture<QueryApiResponse> codePay(
            @Valid @RequestBody final QueryApiRequest request) {
        return CompletableFuture.supplyAsync(() ->
                ApiRegistry.INSTANCE.execute(request));
    }
}
