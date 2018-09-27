package tcm.cloud.spring_cloud_hello_api;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.tcm.api.IHiService2;
import com.tcm.api.vo.User;

/**
 * 
 * api进行单元测试
 *
 * @author zhang 2018年1月24日 下午1:27:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan({"com","tcm"})
@SpringBootTest()
@SpringBootApplication
@EnableDiscoveryClient//远程调用
@EnableFeignClients(basePackages = "com")//远程调用扫描的包
@EnableEurekaClient
public class ApiTest {

    @Autowired
    private IHiService2 hiService2;
    
    @Test
    public void testhi() {
        Map<String,String> map = new HashMap();
        map.put("id", "32904");
        User hi4 = hiService2.hi4(JSON.toJSONString(map));
        System.out.println(JSON.toJSONString(hi4));
    }
    
}
