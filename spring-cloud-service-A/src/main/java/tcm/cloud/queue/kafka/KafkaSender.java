package tcm.cloud.queue.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)  
public class KafkaSender {
    @Autowired  
    private Source source;  
      
    public void sendMessage(String message) {  
    try {  
        source.output1().send(MessageBuilder.withPayload("message: " + message).build());  
    } catch (Exception e) {  
        e.printStackTrace();  
    }  
    }  
}
