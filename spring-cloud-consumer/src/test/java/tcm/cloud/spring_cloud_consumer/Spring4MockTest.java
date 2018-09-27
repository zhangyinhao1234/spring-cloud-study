package tcm.cloud.spring_cloud_consumer;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
/**
 * 
 * 老项目中使用的测试方式
 *
 * @author zhang 2018年1月8日 下午5:09:17
 */
public class Spring4MockTest extends BaseMock{

    @Override
    public void initUserId() {
        // TODO Auto-generated method stub
        
    }

    @Test
    public void receiveEnvelopsTest() throws Exception{
        String url = "/junit/test1";
        Map<String, String> params = super.getParams();
        Map<String, Object> requestmodel = new HashMap();
        requestmodel.put("supSubjectId", "1");
        requestmodel.put("currentPage", "1");
        params.put("requestmodel", JSON.toJSONString(requestmodel));
        params.put("name", "张三");
        post(params, url);
    }
    
}
