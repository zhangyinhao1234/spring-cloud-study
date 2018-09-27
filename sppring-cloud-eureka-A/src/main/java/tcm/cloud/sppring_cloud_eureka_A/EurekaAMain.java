package tcm.cloud.sppring_cloud_eureka_A;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // 启动一个服务注册中心提供给其他应用进行对话
@SpringBootApplication
public class EurekaAMain {

	public static void main(String[] args) {
		SpringApplication.run(EurekaAMain.class, args);
	}
}
