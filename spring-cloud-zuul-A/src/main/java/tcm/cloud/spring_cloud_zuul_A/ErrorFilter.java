package tcm.cloud.spring_cloud_zuul_A;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.web.util.WebUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 
 * 返回的异常处理。
 *
 * @author zhang 2018年1月9日 下午9:10:56
 */
public class ErrorFilter extends ZuulFilter {

    private Log log = LogFactory.getLog(ErrorFilter.class);
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        log.info("hello:"+ctx.get("hello"));
        int responseStatusCode = ctx.getResponseStatusCode();
        if(responseStatusCode == 200) {
            return null;
        }
        
//        Throwable throwable = ctx.getThrowable();
//        ctx.setResponseBody("{error:error,code:"+responseStatusCode+"}");
        return null;
    }
    
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

}
