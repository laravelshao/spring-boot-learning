package com.laravelshao.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by shaoqinghua on 2018/3/23.
 */
@Component
public class Producer {
    private static Logger log = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String topic, Message message) {
        kafkaTemplate.send(topic, message);
        log.info("Producer->topic:{}, message:{}", topic, message);
    }

}
