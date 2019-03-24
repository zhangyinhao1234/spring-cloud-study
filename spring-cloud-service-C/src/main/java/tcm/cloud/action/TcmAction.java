package tcm.cloud.action;

import java.util.ArrayList;
import java.util.HashMap;
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

@RestController
// @EnableAutoConfiguration
@RequestMapping("/service")
public class TcmAction {

    public Log logger = LogFactory.getLog(TcmAction.class);

    @Value("${server.port}")
    private String port;

    @RequestMapping("/tcmService")
    public String tcmService() {
        return port;
    }

    @RequestMapping("/hello")
    public Map hello(HttpServletRequest request,HttpServletResponse response,
            @RequestParam("msg") String msg) {
        System.out.println("---------------- hello : "+msg+"-------------------");
        Map obj = new HashMap();    
        obj.put("hi", "hello:"+msg);
        return obj;
    }

}
