package tcm.cloud.queue.kafka;
/**
 * 
 * kafka
 *
 * @author zhang 2018年1月25日 下午12:04:52
 */

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface  Source {
    //发送队列1  
    String OUTPUT_1 = "output";  
      
    @Output(Source.OUTPUT_1)  
    MessageChannel output1();  
}
