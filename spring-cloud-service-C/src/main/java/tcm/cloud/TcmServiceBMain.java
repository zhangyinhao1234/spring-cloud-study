package tcm.cloud;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 
 * 服务注册到注册中心
 *
 * @author zhang 2017年12月21日 下午3:22:48
 */
//@SpringBootApplication
@SpringCloudApplication
//@EnableEurekaClient
//@ComponentScan({"com","tcm"})//设置扫描的包
public class TcmServiceBMain {
    

	public static void main(String[] args) {
		SpringApplication.run(TcmServiceBMain.class, args);
	}

}
