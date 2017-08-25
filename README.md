## KAFKA DEMO

- 示例提供kafka生产者和消费者测试

- 在本地运行zookeeper和kafka
- 通过docker运行:
```bash
docker-compose up -d
```

- 配置```kafka.properties```

```properties
kafkaUrl=localhost:9092
zkUrl=localhost:2181
```

- [Demo](./src/java/io/terminus/demo/kafka/Demo)