package com.laravelshao.springboot;

import com.laravelshao.springboot.kafka.Message;
import com.laravelshao.springboot.kafka.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IntegrationKafkaApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(IntegrationKafkaApplication.class, args);
        Producer producer = context.getBean(Producer.class);

        for (int i = 1; i < 10; i++) {
            producer.send("test_topic", new Message(i, "test topic message " + i));
            Thread.sleep(2000);
        }
    }

}
