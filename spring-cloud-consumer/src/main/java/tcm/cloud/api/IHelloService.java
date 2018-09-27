package tcm.cloud.api;

//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * 远程调用
 * tcm-server：暴露的服务应用名
 *
 * @author zhang 2017年12月21日 下午7:03:14
 */
//@FeignClient(value = "tcm-server")
public interface IHelloService {

    @RequestMapping("/service/hello")
    String hello();
}
