package cn.shishuihao.thirdparty.api.core;

import cn.shishuihao.thirdparty.api.core.impl.AbstractChannel;
import cn.shishuihao.thirdparty.api.core.impl.ChannelRepositoryMemoryImpl;
import cn.shishuihao.thirdparty.api.core.impl.PropertiesRepositoryMemoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ApiRegistryTest {
    ChannelRepository channelRepository = new ChannelRepositoryMemoryImpl();
    ApiRegistry apiRegistry = new ApiRegistry(channelRepository);

    @Test
    void execute() {
        AlipayPayChannel channel = new AlipayPayChannel();
        channel.add(new CodePayApi());
        channelRepository.add(channel);
        CodePayResponse response = apiRegistry.execute(new CodePayRequest()).orElse(null);
        Assertions.assertNotNull(response);
    }

    static class AlipayPayChannel extends AbstractChannel {
        @Override
        public String id() {
            return AlipayPayChannel.class.getSimpleName();
        }
    }

    static class CodePayApi implements Api<CodePayApi, CodePayRequest, CodePayResponse> {
        private final AlipayPropertiesRepository propertiesRepository = new AlipayPropertiesRepository();

        @Override
        public CodePayResponse execute(CodePayRequest request) throws ApiException {
            try {
                return request.responseClass().newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new ApiException(e);
            }
        }
    }

    static class CodePayRequest implements Request<CodePayApi, CodePayRequest, CodePayResponse> {
        @Override
        public Class<CodePayResponse> responseClass() {
            return CodePayResponse.class;
        }

        @Override
        public String channelId() {
            return AlipayPayChannel.class.getSimpleName();
        }

        @Override
        public Class<CodePayApi> apiType() {
            return CodePayApi.class;
        }
    }

    static class CodePayResponse implements Response {
    }

    static class AlipayPropertiesRepository extends PropertiesRepositoryMemoryImpl {
    }

    static class AlipayProperties implements Properties {
        @Override
        public String id() {
            return AlipayProperties.class.getSimpleName();
        }
    }
}