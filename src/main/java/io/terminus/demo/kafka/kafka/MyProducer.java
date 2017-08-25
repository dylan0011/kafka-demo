package io.terminus.demo.kafka.kafka;

import io.terminus.demo.kafka.KafkaHelper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * Created by yuhp@terminus.io on 2017/8/24.
 * Desc:
 */
public class MyProducer extends Thread {

    private final KafkaProducer<String, String> producer;

    public MyProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaHelper.kafkaUrl());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // 触发acknowledgement机制，否则是fire and forget，可能会引起数据丢失
        // 值为0,1,-1,可以参考
        props.put("request.required.acks", "1");

        producer = new KafkaProducer<String, String>(props);
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            MyTopic topic = MyTopic.get(count % 2 == 0);
            String data = "No." + count++ + ": message . topic is " + topic.name();
            producer.send(new ProducerRecord<String, String>(topic.name(), data));
            producer.flush();
            System.out.println("send message 【" + data + "】 successfully!");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

