package cn.shishuihao.thirdparty.api.sms;

import cn.shishuihao.thirdparty.api.core.channel.ApiChannel;

/**
 * @param <P> sms api properties
 * @author shishuihao
 * @version 1.0.0
 */

public interface SmsApiChannel<
        P extends SmsApiProperties>
        extends ApiChannel<P> {
}
