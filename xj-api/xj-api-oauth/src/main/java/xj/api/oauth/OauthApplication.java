package xj.api.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @ClassName: OauthApplication
 * @Description:
 * @Author:  huqy
 * @Date:  2019/10/23
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAuthorizationServer
public class OauthApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class, args);
    }
}
