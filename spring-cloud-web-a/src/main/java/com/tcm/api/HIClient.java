package com.tcm.api;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.tcm.api.fallfactory.HiServiceHystrixFactory;
import com.tcm.hystrix.HIClientHystrixFactory;

@FeignClient(value = "tcm-server",primary = false,fallbackFactory=HIClientHystrixFactory.class)
public interface HIClient extends IHiService2{

}
