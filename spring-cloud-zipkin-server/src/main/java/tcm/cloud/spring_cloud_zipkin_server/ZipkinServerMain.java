package tcm.cloud.spring_cloud_zipkin_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import org.springframework.context.annotation.ComponentScan;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"com","tcm"})//设置扫描的包
//@EnableZipkinServer
@EnableZipkinStreamServer
public class ZipkinServerMain {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerMain.class, args);
    }
}
