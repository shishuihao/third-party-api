package cn.shishuihao.thirdparty.api.pay.icbc.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.CodePayApi;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayClient;
import cn.shishuihao.thirdparty.api.pay.icbc.assembler.IcbcRequestAssembler;
import cn.shishuihao.thirdparty.api.pay.icbc.assembler.IcbcResponseAssembler;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import com.icbc.api.response.QrcodePayResponseV2;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class IcbcCodePayApi implements CodePayApi {
    /**
     * IcbcPayClient.
     */
    private final IcbcPayClient icbcPayClient;

    /**
     * execute CodePayApiRequest by icbc.
     *
     * @param request request
     * @return CodePayApiResponse
     */
    @Override
    public CodePayApiResponse execute(final CodePayApiRequest request) {
        IcbcPayApiProperties properties = (IcbcPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            QrcodePayResponseV2 response = icbcPayClient
                    .getClient(properties)
                    .execute(IcbcRequestAssembler.INSTANCE
                            .assemble(request, properties));
            return IcbcResponseAssembler.INSTANCE
                    .assemble(response);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
