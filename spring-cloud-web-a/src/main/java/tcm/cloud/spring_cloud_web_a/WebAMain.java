package tcm.cloud.spring_cloud_web_a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient//远程调用
@RestController
@EnableFeignClients(basePackages = "com")//远程调用扫描的包
@ComponentScan({"com","tcm"})//设置扫描的包
public class WebAMain {
    public static void main(String[] args) {
        SpringApplication.run(WebAMain.class, args);
    }
}
