package com.tcm.api.fallfactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcm.api.IHiService;
import com.tcm.api.IHiService2;
import com.tcm.api.expection.ApiClientExpection;
import com.tcm.api.vo.User;

import feign.hystrix.FallbackFactory;

/**
 * 
 * 1、在一些场景中，简单的触发在 FeignClient 加入 Fallback 属性即可，而另外有一些场景需要访问导致回退触发的原因，那么这个时候可以在
 * FeignClient 中加入 FallbackFactory 属性即可； 2、而在使用 Fallback 和 FallbackFactory
 * 时候，我仅仅表述个人观点，发现二者混合一起用的话，会发生冲突情况，所以大家用的时候注重考虑一下场景，二者属性用其一即可。
 *
 * @author zhang 2018年1月23日 下午1:47:31
 */
@Component
public class HiServiceHystrixFactory implements FallbackFactory<IHiService2> {

    private Log logger = LogFactory.getLog(HiServiceHystrixFactory.class);
    @Autowired(required = false)
    private IHiService2create hiService2create;

    @Override
    public IHiService2 create(Throwable cause) {
        // logger.error("熔断原因", cause);
        // 默认熔断
        if (hiService2create == null) {
            // 默认的熔断器（某些业务抛出异常，某些业务允许异常）
            return new IHiService2() {
                @Override
                public User hi4(String requestmodel) {
//                    if (true) {
//                        throw new ApiClientExpection(cause.getLocalizedMessage());
//                    }
                    System.out.println("HiServiceHystrixFactory ...... hi4");
                    return null;
                }

                @Override
                public String tcmService() {

                    return null;
                }
            };
        }
        return hiService2create.create(cause);
    }
}
