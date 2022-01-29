package com.kafka.kafkaStream.listener;

import com.kafka.kafkaStream.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "kafka_example", groupId = "myConsumerGroup")
    public void consume(String message){
        System.out.println("consumed message "+message);
    }

    @KafkaListener(topics = "kafka_example_json", groupId = "myConsumerGroup_json",
    containerFactory = "userKafkaListerFactory")
    public void consumeJson(User user){
        System.out.println("Consumed Json message : "+user);
    }
}
