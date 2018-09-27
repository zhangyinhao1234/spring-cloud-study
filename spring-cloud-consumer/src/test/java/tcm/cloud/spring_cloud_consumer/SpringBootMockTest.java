package tcm.cloud.spring_cloud_consumer;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.tcm.junit.WebJunitTestAction;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ComponentScan({"com","tcm"})
@SpringBootTest(classes=ConsumerAMain.class)

public class SpringBootMockTest {
    Log logger =LogFactory.getLog(getClass());
    @Autowired
    private WebJunitTestAction controller;
    
    
    
    
    
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
        mvc.perform(MockMvcRequestBuilders.get("/junit/test1")
                .param("name", "张殷豪")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                ;
    }
   
    
}
