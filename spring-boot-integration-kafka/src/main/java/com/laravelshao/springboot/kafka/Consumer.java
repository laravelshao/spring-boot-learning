package com.laravelshao.springboot.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by shaoqinghua on 2018/3/23.
 */
@Component
public class Consumer {
    private static Logger log = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "test_topic")
    public void receive(ConsumerRecord<String, Message> consumerRecord) {
        log.info("Consumer->topic:{}, value:{}", consumerRecord.topic(), consumerRecord.value());
    }

}
