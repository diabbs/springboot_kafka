package com.kafka.kafkaStream.controller;

import com.kafka.kafkaStream.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserController {
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    private static final String TOPIC = "kafka_example";
    @GetMapping("/publish/{lastName}")
    public String post(@PathVariable("lastName") final String lastName){

        kafkaTemplate.send(TOPIC, new User("toto@yopmail.com","John",lastName));
        return "Publish successfully";
    }
}

