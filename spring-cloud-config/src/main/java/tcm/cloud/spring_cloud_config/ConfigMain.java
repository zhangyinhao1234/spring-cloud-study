package tcm.cloud.spring_cloud_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigServer
@EnableAutoConfiguration  
@EnableEurekaClient
@ComponentScan({"com","tcm"})//设置扫描的包
public class ConfigMain {

	public static void main(String[] args) {
		SpringApplication.run(ConfigMain.class, args);
	}
}
