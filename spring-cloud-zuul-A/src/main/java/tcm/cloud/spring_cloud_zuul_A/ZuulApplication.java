package tcm.cloud.spring_cloud_zuul_A;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Component;

@EnableZuulProxy
@SpringCloudApplication
@Component("com")
public class ZuulApplication {
    private static Log logger = LogFactory.getLog(ZuulApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
//        logger.info("hello......");
    }
}
