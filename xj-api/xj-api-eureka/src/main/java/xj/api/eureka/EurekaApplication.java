package xj.api.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *@Description: 注册中心
 *@Author:  huqy
 *@Date:  2020/1/13
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}

}
