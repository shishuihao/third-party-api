package cn.shishuihao.thirdparty.api.push.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * push http api.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@SpringBootApplication
public class ThirdPartyApiPushApplication {
    /**
     * 启动入口.
     *
     * @param args the application arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(ThirdPartyApiPushApplication.class, args);
    }
}
