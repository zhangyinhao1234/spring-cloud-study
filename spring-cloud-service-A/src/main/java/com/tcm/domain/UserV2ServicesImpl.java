package com.tcm.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tcm.framework.core.dao.query.page.v2.BaseServiceImpl;

@Service
public class UserV2ServicesImpl extends BaseServiceImpl<UserV2> implements IUserV2Services {


    /**
     * 测试本地方法熔断，出现错误调用方法  testuserUpError 进行错误处理
     */
    @Transactional
    @Override
    @HystrixCommand(fallbackMethod = "testuserUpError",
        commandProperties= {@HystrixProperty(name="metrics.rollingStats.timeInMilliseconds",value="4000"),
                @HystrixProperty(name="execution.timeout.enabled",value="true")} )
    public String testuserUp(String trueName) {
        UserV2 objById = getObjById(32904L);
        objById.setTrueName(trueName);
        update(objById);

        if (true) {
            throw new NullPointerException();
        }
        return "success";
    }
    
    public String testuserUpError(String trueName) {
        System.out.println("testuserUp 出现异常 熔断 ");
        return "异常";
    }
    
    

}
