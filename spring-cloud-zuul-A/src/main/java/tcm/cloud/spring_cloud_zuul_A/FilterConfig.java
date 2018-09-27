package tcm.cloud.spring_cloud_zuul_A;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public UserLoginFilter accessUserNameFilter() {
        return new UserLoginFilter();
    }
//    @Bean
//    public ErrorFilter errorFilter() {
//        return new ErrorFilter();
//    }
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
