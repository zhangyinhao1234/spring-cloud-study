package com.tcm.api;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcm.hystrix.HelloServiceHystrix;
import com.tcm.service.UserV2;
/**
 * 
 * 远程调用
 * tcm-server：暴露的服务应用名
 * fallback:对方法调用进行熔断处理。
 *
 * @author zhang 2017年12月21日 下午7:03:14
 */
@FeignClient(value = "tcm-server",fallback = HelloServiceHystrix.class)
public interface IHelloService {

    @RequestMapping("/service/hello")
    UserV2 hello(@RequestParam("hello") String hello,@RequestParam("msg") String msg);
    /**
     * 
     * 做为参数传递
     * 
     * @param ids 
     * @return
     */
    @RequestMapping("/service/hi")
    List<UserV2> hi(@RequestParam("ids") List<Long> ids);
    
    /**
     * 
     * 将数据放到body中进行传递，
     * 
     * @param userV2s
     * @return
     */
    @RequestMapping("/service/hi2")
    List<UserV2> hi2(@RequestBody List<UserV2> userV2s,@RequestParam("hello") String hello );
    
    @RequestMapping("/service/hi3")
    List<UserV2> hi3(@RequestParam("ids") List<Long> ids,@RequestParam("userV2s") List<UserV2> userV2s);
    
    /**
     * 
     * 全json格式
     * 
     * @param requestmodel
     * @return
     */
    @RequestMapping("/service/hi4")
    UserV2 hi4(@RequestParam("requestmodel") String requestmodel);
}
