package cn.shishuihao.thirdparty.api.push.oppo.assembler;

import cn.shishuihao.thirdparty.api.push.oppo.util.ResultChecker;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import com.oppo.push.server.Result;

import java.util.Optional;

/**
 * 响应装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class OppoPushResponseAssembler {
    /**
     * 实例.
     */
    public static final OppoPushResponseAssembler INSTANCE
            = new OppoPushResponseAssembler();

    /**
     * 装配.
     *
     * @param result 响应
     * @return {@link PushMessageApiResponse}
     */
    public PushMessageApiResponse assemble(
            final Result result) {
        return PushMessageApiResponse.builder()
                .success(ResultChecker.success(result))
                .code(Optional.ofNullable(result.getReturnCode())
                        .map(it -> it.getCode() + "," + it.getMessage())
                        .orElse(null))
                .message(result.getReason())
                .build();
    }
}
