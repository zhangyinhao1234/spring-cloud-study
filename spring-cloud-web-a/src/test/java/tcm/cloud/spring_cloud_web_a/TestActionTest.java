package tcm.cloud.spring_cloud_web_a;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.alibaba.fastjson.JSON;
import com.tcm.api.vo.User;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=WebAMain.class)
public class TestActionTest {
    Log logger =LogFactory.getLog(getClass());
    @Autowired
    private  TestAction controller;
    private MockMvc mvc;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    /**
     * 
     * 简单调用
     * 
     * @throws Exception
     */
    @Test
    public void test11() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/tcmService")
                .param("name", "张殷豪")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                ;
    }
    
    /**
     * 
     * 带有远程调用的
     * 
     * @throws Exception
     */
    @Test
    public void testWithFeign() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/tcmService")
                .param("name", "张殷豪")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                ;
    }
    /**
     * 
     * request body 调用
     * 
     * @throws Exception
     */
    @Test
    public void testrequestbody() throws Exception {
        User u =new User();
        mvc.perform(MockMvcRequestBuilders.post("/user/testrequestbody")
                .content(JSON.toJSONString(u)).contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                ;
    }
    
    @Test
    public void testSystrix() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/testSystrix")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                ;
    }
    
    
}
