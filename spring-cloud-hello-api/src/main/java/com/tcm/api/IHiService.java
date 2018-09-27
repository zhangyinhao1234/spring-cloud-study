package com.tcm.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcm.api.fallback.HiServiceHystrix;
import com.tcm.api.vo.User;
@FeignClient(value = "tcm-server",fallback = HiServiceHystrix.class)
public interface IHiService {
    /**
     * 
     * 全json格式
     * 
     * @param requestmodel
     * @return
     */
    @RequestMapping("/service/hi4")
    User hi4(@RequestParam("requestmodel") String requestmodel);
    @RequestMapping("/service/tcmService")
    String tcmService ();
}
