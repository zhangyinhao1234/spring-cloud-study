package tcm.cloud.spring_cloud_eureka_B;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // 启动一个服务注册中心提供给其他应用进行对话
@SpringBootApplication
public class EurekaBMain {

	public static void main(String[] args) {
		SpringApplication.run(EurekaBMain.class, args);
	}
}
