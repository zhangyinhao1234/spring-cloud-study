package tcm.cloud.spring_cloud_consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tcm.cloud.api.IHelloService;
@SpringBootApplication
//@EnableEurekaClient
//@EnableDiscoveryClient
@RestController
//@EnableAutoConfiguration
//@EnableFeignClients(basePackages = "tcm")
@ComponentScan({"com","tcm"})//设置扫描的包
public class ConsumerAMain {
    
    private Log logger = LogFactory.getLog(ConsumerAMain.class);

//    @Autowired
//    private IHelloService helloService;
    
    @Value("${user.teleohone}")
    private String userTelephone;
    
//    @RequestMapping("helloAction")
//    public String helloAction() {
//        String hello = helloService.hello();
        
//        return "张三说："+hello+":我手机号"+userTelephone;
//    }
    public static void main(String[] args) {
        SpringApplication.run(ConsumerAMain.class, args);
    }
    
    @RequestMapping("hiAction")
    public String hi() {
        logger.info("---------------");
        return "ok";
    }
    
    
}
