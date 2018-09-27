package tcm.cloud.queue.kafka;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class KafkaReceiver {
    private Log logger = LogFactory.getLog(KafkaReceiver.class);
    @StreamListener(Sink.INPUT)
    public void process(Message<?> message) {
//        if(true) {
//            throw new NullPointerException("000000000");
//        }
        //适用在 topic 上  因为发送之后就不管成功失败不会再次消费
        System.out.println("KafkaReceiver:"+message.getPayload());
        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        if (acknowledgment != null) {
            System.out.println("Acknowledgment provided");
            acknowledgment.acknowledge();
        }
    }
}
