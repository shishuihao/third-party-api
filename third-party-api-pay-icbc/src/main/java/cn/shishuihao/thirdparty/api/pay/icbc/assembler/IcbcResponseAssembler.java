package cn.shishuihao.thirdparty.api.pay.icbc.assembler;

import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import com.icbc.api.response.QrcodePayResponseV2;

/**
 * 响应装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class IcbcResponseAssembler {
    /**
     * 实例.
     */
    public static final IcbcResponseAssembler INSTANCE
            = new IcbcResponseAssembler();

    /**
     * 装配.
     *
     * @param response 二维码被扫支付响应
     * @return {@link CodePayApiResponse}
     */
    public CodePayApiResponse assemble(
            final QrcodePayResponseV2 response) {
        return CodePayApiResponse.builder()
                .success(response.isSuccess())
                .code(String.valueOf(response.getReturnCode()))
                .message(response.getReturnMsg())
                .requestId(response.getMsgId())
                .build();
    }
}
