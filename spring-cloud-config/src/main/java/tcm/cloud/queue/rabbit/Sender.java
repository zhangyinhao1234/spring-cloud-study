package tcm.cloud.queue.rabbit;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * 
 * 消息生产者
 *
 * @author zhang 2018年1月23日 下午11:09:53
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send() {
        String msg = "hello rabbitmq:"+new Date()+"张三";
        System.out.println("Sender:"+msg);
        //注入AmqpTemplate，然后利用AmqpTemplate向一个名为hello的消息队列中发送消息。
        this.rabbitTemplate.convertAndSend("hello", msg);
    }
    
    
    
}
