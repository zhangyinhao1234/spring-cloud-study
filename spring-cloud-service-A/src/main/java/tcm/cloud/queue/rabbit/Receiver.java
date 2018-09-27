package tcm.cloud.queue.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * 
 * 消息消费者
 * @RabbitListener(queues = "hello")注解表示该消息消费者监听hello这个消息队列，
 * @RabbitHandler注解则表示process方法是用来处理接收到的消息的，我们这里收到消息后直接打印即可。
 *
 * @author zhang 2018年1月23日 下午11:10:21
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("Receiver:"+msg);
        if(true) {
            throw new NullPointerException("消费失败");
        }
    }
}
