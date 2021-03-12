package cn.shishuihao.thirdparty.api.tts;

import cn.shishuihao.thirdparty.api.core.channel.ApiChannel;

/**
 * @param <P> tts api properties
 * @author shishuihao
 * @version 1.0.0
 */
public interface TtsApiChannel<
        P extends TtsApiProperties>
        extends ApiChannel<P> {
}
