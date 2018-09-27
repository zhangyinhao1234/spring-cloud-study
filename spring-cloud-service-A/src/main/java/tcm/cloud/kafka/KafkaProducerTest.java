package tcm.cloud.kafka;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.KafkaProducer;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;
public class KafkaProducerTest  extends Thread{
    private String topic;
    public KafkaProducerTest(String topic){
        super();
        this.topic = topic;
    }
    public static void main(String[] args) {
        new KafkaProducerTest("springcloudbus").start();
    }
    @Override
    public void run() {
        Producer producer =createProducer();
        int i = 0;
        while(true){
            producer.send(new KeyedMessage<Integer, String>(topic, "message:"+i++));;
            System.out.println("发送成功！");
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    private Producer createProducer(){
        Properties properties = new Properties();
        properties.put("zk.connect", "127.0.0.1:2181");
        properties.put("serializer.class",StringEncoder.class.getName());
        properties.put("metadata.broker.list","192.168.14.180:9092");
        return new Producer<Integer, String>(new ProducerConfig(properties));
    }
    
}
