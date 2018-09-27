package tcm.cloud.queue.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    /**
     * 
     * 创建一个名为hello的消息队列。
     * 
     * @return
     */
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
