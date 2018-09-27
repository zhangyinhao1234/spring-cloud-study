package tcm.cloud.spring_cloud_web_a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.tcm.api.HIClient;
import com.tcm.api.IHelloService;
import com.tcm.api.IHelloService2;
import com.tcm.api.IHelloService3;
import com.tcm.api.IHiService;
import com.tcm.api.IHiService2;
import com.tcm.api.UserClient;
import com.tcm.api.vo.User;
import com.tcm.service.IUserV2Services;
import com.tcm.service.UserV2;


@RestController
@RequestMapping("/user")
public class TestAction {
    @Autowired
    private IUserV2Services userService;

    @RequestMapping("/{id}")
    public UserV2 getUser(@PathVariable("id") Long id) {
        return userService.getObjById(id);
    }
    
    /**
     * 
     * 事务测试，可以回滚事务
     * 
     * @param id
     * @param userName
     * @return
     */
    @Transactional
    @RequestMapping("/update/{id}/{userName}")
    public UserV2 getUser(@PathVariable("id") Long id,@PathVariable("userName") String userName) {
         UserV2 user = userService.getObjById(id);
         user.setUserName(userName);
         this.userService.update(user);
         if(true) {
             throw new NullPointerException();
         }
         
         return user;
    }
    @Autowired
    private IHelloService helloService;
    
    @RequestMapping("/hello")
    public void hello() {
        UserV2 hello = helloService.hello("你好","zhangsan .....");
        System.out.println(JSON.toJSONString(hello));
    }
    
    @Autowired
    private IHelloService2 helloService2;
    @Autowired
    private IHelloService3 helloService3;
    
    @RequestMapping("/hi")
    public String hi() {
        UserV2 userV2 = new UserV2();
        userV2.setTrueName("请求的");
        
        List<UserV2> hi = helloService.hi(Lists.newArrayList(32904L));
        System.out.println(JSON.toJSONString(hi));
        
        List<UserV2> list = new ArrayList<UserV2>();
        list.add(userV2);
        hi = helloService.hi2(list,"ddd");
        System.out.println(JSON.toJSONString(hi));
        hi = helloService.hi3(Lists.newArrayList(32904L),list);
        System.out.println(JSON.toJSONString(hi));
        
        Map<String,String> map = new HashMap();
        map.put("id", "32904");
//        UserV2 hi4 = helloService2.hi4(JSON.toJSONString(map));
//        System.out.println(JSON.toJSONString(hi4));
        
        UserV2 hi42 = helloService3.hi4(JSON.toJSONString(map));
        
        return "ok";
    }
    
    @Autowired
    private IHiService hiService;
    
    @Autowired
    private IHiService2 hiService2;
    @RequestMapping("/hi2")
    public User hi2() {
        Map<String,String> map = new HashMap();
        map.put("id", "32904");
        User hi4 = hiService.hi4(JSON.toJSONString(map));
        return hi4;
    }
    
    /**
     * 继承了原来的远程调用并且需要进行熔断处理的，用 @Resource
     * 如果只是继承，并且不需要熔断的那么  @Autowired
     */
    @Resource(name="com.tcm.api.UserClient")
    private UserClient userClient;
    
    @RequestMapping("/tcmService")
    public User tcmService() {
        Map<String, String> map = new HashMap();
        map.put("id", "32904");
        User hi4 = userClient.hi4(JSON.toJSONString(map));
        return hi4;
    }

    @Resource(name="com.tcm.api.HIClient")
    private HIClient hiclient;
    
    @RequestMapping("/testSystrix")
    public User testSystrix() {
        return hiclient.hi4(null);
    }
    
    

    /**
     * 
     * requestbody 
     * 
     * @param user
     * @return
     */
    @RequestMapping("/testrequestbody")
    public User testrequestbody(@RequestBody User user) {
        user.setTrueName("张殷豪");
        return user;
    }
    
   
}
