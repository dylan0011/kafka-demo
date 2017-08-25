package io.terminus.demo.kafka.kafka;

/**
 * Created by yuhp@terminus.io on 2017/8/24.
 * Desc:
 */
public enum MyTopic {
    TOPIC_WIND, TOPIC_RAIN;

    public static MyTopic get(boolean flag) {
        return flag ? TOPIC_RAIN : TOPIC_WIND;
    }

}
