package com.tcm.hystrix;

import org.springframework.stereotype.Component;

import com.tcm.api.IHiService2;
import com.tcm.api.expection.ApiClientExpection;
import com.tcm.api.fallfactory.IHiService2create;
import com.tcm.api.vo.User;
/**
 * 
 * 重写默认的熔断机制处理
 *
 * @author zhang 2018年1月23日 下午4:30:26
 */
@Component
public class IHiService2createImpl implements IHiService2create{

    @Override
    public IHiService2 create(final Throwable cause) {
        return new IHiService2() {
            @Override
            public User hi4(String requestmodel) {
                System.out.println("IHiService2createImpl ...... hi4");
                return null;
            }

            @Override
            public String tcmService() {
                
                return null;
            }

        };
    }

}
