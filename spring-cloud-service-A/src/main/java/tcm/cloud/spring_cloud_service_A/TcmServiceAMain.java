package tcm.cloud.spring_cloud_service_A;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.tcm.domain.IUserV2Services;
import com.tcm.domain.UserV2;

/**
 * 
 * 服务注册到注册中心
 *
 * @author zhang 2017年12月21日 下午3:22:48
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"com","tcm"})//设置扫描的包
@EnableHystrix//对本地方法使用熔断
public class TcmServiceAMain {
	public static void main(String[] args) {
		SpringApplication.run(TcmServiceAMain.class, args);
	}
}
