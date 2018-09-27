package tcm.cloud.spring_cloud_web_a;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;

@Controller
public class ThymeleafAction {

    @RequestMapping("/view/index.htm")
    public ModelAndView helloV(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getParameter("id"));
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("title", "淘菜猫");
        mv.addObject("count", "123");
        mv.addObject("id", 232323232309876545L);
        mv.addObject("content", "hello <br/> tcm");
        
        List newArrayList = Lists.newArrayList();
        Map obj = new HashMap();
        obj.put("name", "张三");
        obj.put("age", "23");
        obj.put("id", "1");
        obj.put("imageUrl", "http://img.zcool.cn/community/017274582000cea84a0e282b576a32.jpg");
        newArrayList.add(obj);
        obj = new HashMap();
        obj.put("name", "李四");
        obj.put("age", "24");
        obj.put("id", "2");
        obj.put("imageUrl", "http://img.zcool.cn/community/017274582000cea84a0e282b576a32.jpg");
        newArrayList.add(obj);
        mv.addObject("users", newArrayList);
        
        mv.addObject("today", new Date());
        
        mv.addObject("stru", new StringUtils());
        
        return mv;
    }
}
