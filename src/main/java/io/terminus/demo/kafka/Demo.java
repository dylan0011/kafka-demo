package io.terminus.demo.kafka;

import io.terminus.demo.kafka.kafka.MyConsumer;
import io.terminus.demo.kafka.kafka.MyProducer;
import io.terminus.demo.kafka.kafka.MyTopic;

/**
 * Created by yuhp@terminus.io on 2017/8/24.
 * Desc:
 */
public class Demo {

    public static void main(String[] args) {
        new MyProducer().start();
        new MyConsumer(MyTopic.TOPIC_WIND).start();
    }

}
