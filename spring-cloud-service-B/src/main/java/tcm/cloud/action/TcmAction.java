package tcm.cloud.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.tcm.business.tools.logstash.BigDataLogFactory;
import com.tcm.business.tools.logstash.LoggerAppender;
import com.tcm.business.tools.logstash.model.TcmAccessLog;
import com.tcm.business.tools.logstash.model.TcmAppOpLog;
import com.tcm.domain.IUserV2Services;
import com.tcm.domain.UserV2;

@RestController
//@EnableAutoConfiguration
@RequestMapping("/service")
public class TcmAction {
    @Autowired
    private IUserV2Services userService;
    
    public Log logger = LogFactory.getLog(TcmAction.class);
    
    @Value("${server.port}")
    private String port;
    
    @RequestMapping("/tcmService")
    public String tcmService() {
        return port;
    }
    

    @RequestMapping("/hello")
    public UserV2 hello(HttpServletRequest request,HttpServletResponse response,
            @RequestParam(value = "hello",required=false) String hello,@RequestParam("msg") String msg) {
        //required = false 不是必须字段
        logger.info("hello ......"+"userid:"+request.getAttribute("userId")+hello+msg);
        //没有数据
        String parameter = request.getParameter("hello");
        
        String user = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
                .getHeader("X-AUTH-ID");
        
        logger.info("网关传递数据：X-AUTH-ID:"+user);
        logger.debug("网关传递数据：X-AUTH-ID:"+user);
        if(true) {
//          throw new NullPointerException("eexbxcdbxvxe");
            logger.error(new NullPointerException("33333"));
        }
        
        LoggerAppender.info("helo");
        return userService.getObjById(32904L);
    }
    
    @RequestMapping("/testuserUp")
    public String testupdate() {
        return userService.testuserUp("");
    }
    
    /**
     * 
     * logback 数据传输到大数据平台测试
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/saveaccess")
    public TcmAppOpLog saveaccess(HttpServletRequest request,HttpServletResponse response) {
        TcmAppOpLog tcmAccessLog = new TcmAppOpLog();
        tcmAccessLog.setIp("127.0.0.2");
        BigDataLogFactory.getLogger().info(tcmAccessLog);
        return tcmAccessLog;
    }
    
    /**
     * 
     * logback 数据传输到ELK测试
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/saveInfoToELK")
    public void saveInfoToELK(HttpServletRequest request,HttpServletResponse response) {
        String string = UUID.randomUUID().toString();
        System.out.println(string);
        LoggerAppender.info(string);
        
//        String ss = null;
//        ss.equals("");
    }
    
    
    @RequestMapping("/hi")
    public List<UserV2> hi( @RequestParam("ids")  List<Long> ids) {
        List<UserV2> users = new ArrayList<>();
        for(Long id : ids) {
            UserV2 user = userService.getObjById(id);
            users.add(user);
        }
        return users;
    }
    
    @RequestMapping("/hi2")
    public List<UserV2> hi2(@RequestBody List<UserV2> userV2s,@RequestParam(value = "hello") String hello ) {
        List<UserV2> users = new ArrayList<>();
        return users;
    }
    
    @RequestMapping("/hi3")
    public List<UserV2> hi3(@RequestParam("ids")  List<Long> ids,@RequestParam("userV2s") List<UserV2> userV2s) {
        List<UserV2> users = new ArrayList<>();
        return users;
    }
    
    @RequestMapping("/hi4")
    public UserV2 hi4(@RequestParam("requestmodel")  String requestmodel) {
        System.out.println("hi4:"+requestmodel);
        Map<String,String> parseObject = JSON.parseObject(requestmodel, Map.class);
        String id = parseObject.get("id");
        UserV2 objById = this.userService.getObjById(Long.valueOf(id));
//        if(true) {
//            throw new NullPointerException("ddddd");
//        }
        return objById;
    }
    
    public static void main(String[] args) {
        TcmAction tcmAction = new TcmAction();
//        tcmAction.saveaccess(null, null);
        
//        tcmAction.saveInfoToELK(null, null);
        
        tcmAction.logger.info("dddd");
    }
    
    
}
