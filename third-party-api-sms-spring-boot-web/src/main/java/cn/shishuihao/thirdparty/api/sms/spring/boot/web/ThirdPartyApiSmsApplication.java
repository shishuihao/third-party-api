package cn.shishuihao.thirdparty.api.sms.spring.boot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * sms http api.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@SpringBootApplication
public class ThirdPartyApiSmsApplication {
    /**
     * 启动入口.
     *
     * @param args the application arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(ThirdPartyApiSmsApplication.class, args);
    }
}
