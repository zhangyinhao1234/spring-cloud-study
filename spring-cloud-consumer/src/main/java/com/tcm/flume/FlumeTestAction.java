package com.tcm.flume;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class FlumeTestAction {
    
    Log logger = LogFactory.getLog(FlumeTestAction.class);

    @RequestMapping("/flume/{info}")
    public String testflume(@PathVariable("info") String info) {
        logger.info(info);
        return info;
    }
}
