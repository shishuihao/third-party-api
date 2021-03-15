package cn.shishuihao.thirdparty.api.pay.spring.boot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * pay http api.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@SpringBootApplication
public class ThirdPartyApiPayApplication {
    /**
     * 启动入口.
     *
     * @param args the application arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(ThirdPartyApiPayApplication.class, args);
    }
}
