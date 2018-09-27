package tcm.cloud.spring_cloud_consumer;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;


@ComponentScan({"com","tcm"})
@SpringBootTest(classes=ConsumerAMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ActiveProfiles("dev")
//-Xms512m -Xmx512m -XX:MaxNewSize=512m -XX:MaxPermSize=512m
public abstract class BaseMock {

    private Log logger = LogFactory.getLog(BaseMock.class);
    @Autowired  
    public WebApplicationContext wac;  
    public MockMvc mockMvc;  
    /**
     * 需要登陆的接口的默认的用户id，需要修改的请求mock测试中自行修改
     */
    private String userId= "32904";
    @Autowired
    public WebApplicationContext webApplicationContext;
  
    /**
     * 是否打印请求头信息
     * 开发调试时候可以设置为true，在测试环境进行maven test的时候必须设置为false
     */
    private boolean printHandlers = true;
    @Before  
    public void setup() throws Exception {  
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();  
        initUserId();
    } 
    
    
    public Map<String,String> getParams(){
        return new HashMap<String, String>();
    }
    
    public Map getRequestmodel(){
        return new HashMap();
    }
    
    public void setRequestmodel(Map<String,String> params,Map requestmodel){
        params.put("requestmodel", JSON.toJSONString(requestmodel));
    }
    
    
    public Map<String, Object> post(Map<String,String> params,String url) throws Exception{
        logger.info("mock测试：接口："+url);
        logger.info(url+"请求参数："+JSON.toJSONString(params));
        
        MockHttpServletRequestBuilder post = MockMvcRequestBuilders.post(url);
        post.cookie(new Cookie("userToken",getUserId()));
        for(Map.Entry<String, String> entity : params.entrySet()){
            post.param(entity.getKey(), entity.getValue());
        }
        post.accept(MediaType.APPLICATION_JSON_UTF8);
        ResultActions perform = mockMvc.perform(post);
        perform.andExpect(status().isOk());
        if(printHandlers){
            perform.andDo(MockMvcResultHandlers.print());
        }
        MvcResult andReturn = perform.andReturn();
        ModelMap modelMap = andReturn.getModelAndView().getModelMap();
        ModelAndView modelAndView = andReturn.getModelAndView();
        modelAndView = (ModelAndView)modelMap.get("modelAndView");
        logger.info("接口："+url+";返回结果："+JSON.toJSONString(modelAndView.getModel()));
        return modelAndView.getModel();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * 
     * 需要登陆的接口的默认的用户{@link #userId}，需要修改的请求mock测试中自行修改
     * 调用{@link #setUserId(String)}
     *
     */
    public abstract void initUserId() ;
    
    public String getUserId() {
//        return UserSignin.signin(userId, 3600);
        
        return "";
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    
}
