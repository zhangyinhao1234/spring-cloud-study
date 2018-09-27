package com.tcm.hystrix;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.tcm.api.IHelloService;
import com.tcm.service.UserV2;

/**
 * 
 * 对远程调用进行熔断措施处理
 *
 * @author zhang 2018年1月19日 下午1:31:12
 */
@Component
public class HelloServiceHystrix implements IHelloService {

    private Log logger = LogFactory.getLog(HelloServiceHystrix.class);

    @Override
    public UserV2 hello(String hello,String msg) {
        logger.debug("方法调用失败。。。。进行熔断措施");
        UserV2 userV2 = new UserV2();
        userV2.setUserName("我被熔断了，我只是一个缓存副本数据");
        return userV2;
    }

    @Override
    public List<UserV2> hi(List<Long> ids) {
        logger.debug("方法调用失败。。。。进行熔断措施"+"请求数据："+JSON.toJSONString(ids));
        UserV2 userV2 = new UserV2();
        userV2.setUserName("hi。。。我被熔断了，我只是一个缓存副本数据");
        return Lists.newArrayList(userV2);
    }

    @Override
    public List<UserV2> hi2(List<UserV2> userV2s,String ss) {
        UserV2 userV2 = new UserV2();
        userV2.setUserName("hi2.。。我被熔断了..........");
        return Lists.newArrayList(userV2);
    }

    @Override
    public List<UserV2> hi3(List<Long> ids, List<UserV2> userV2s) {
        UserV2 userV2 = new UserV2();
        userV2.setUserName("hi3.。。。我被熔断了0000000000000");
        return Lists.newArrayList(userV2);
    }

    @Override
    public UserV2 hi4(String requestmodel) {
        UserV2 userV2 = new UserV2();
        userV2.setUserName("hi4.。。我被熔断了0000000000000");
        return userV2;
    }

}
