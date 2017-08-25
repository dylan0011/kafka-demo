package io.terminus.demo.kafka;

import java.util.Properties;

/**
 * Created by yuhp@terminus.io on 2017/8/24.
 * Desc:
 */
public class KafkaHelper {

    private static Properties prop = new Properties();

    static {
        try {
            prop.load(KafkaHelper.class.getClassLoader().getResourceAsStream("kafka.properties"));
            if (prop.getProperty("zkUrl") == null) {
                System.out.println("zkUrl not set in mongo.properties!");
                System.exit(-1);
            }
            if (prop.getProperty("kafkaUrl") == null) {
                System.out.println("kafkaUrl not set in mongo.properties!");
                System.exit(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String zkUrl() {
        return prop.getProperty("zkUrl");
    }

    public static String kafkaUrl() {
        return prop.getProperty("kafkaUrl");
    }

}
