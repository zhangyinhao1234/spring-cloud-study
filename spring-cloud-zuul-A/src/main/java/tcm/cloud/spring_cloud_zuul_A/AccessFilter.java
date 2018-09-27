package tcm.cloud.spring_cloud_zuul_A;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.CoyoteOutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 
 * 访问日志
 *
 * @author zhang 2018年1月10日 下午3:59:04
 */
public class AccessFilter extends ZuulFilter{

    private Log logger = LogFactory.getLog(AccessFilter.class);
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        String parameter = request.getParameter("hello");
        logger.debug("request params : hello: "+parameter);
        InputStream is = ctx.getResponseDataStream();
        
        String callback = request.getParameter("callback");
        if (callback != null && !"".equals(callback)) {
            //获取后端应用服务器的response数据
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));   
            StringBuilder sb = new StringBuilder();   
            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String jsonString = sb.toString();
            if (callback != null && !"".equals(callback)) {// 跨域处理
                jsonString = callback + "(" + jsonString + ")";
            }
            response.setHeader("Content-type", "application/json;charset=UTF-8");
            // 支持跨域访问
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
            response.setHeader("Access-Control-Expose-Headers", "*");
            
            ctx.setResponseBody(jsonString);
        }
        
        return null;
    }

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 3;
    }

}
