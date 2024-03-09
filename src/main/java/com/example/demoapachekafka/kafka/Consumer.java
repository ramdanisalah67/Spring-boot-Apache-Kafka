package com.example.demoapachekafka.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {


    @KafkaListener(topics = "Topic-salah",groupId = "myGroup")
    public void consume(String message){
    log.info(String.format("Message received -> %s",message));

    }
}