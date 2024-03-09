package com.example.demoapachekafka.kafka;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Producer {


    private KafkaTemplate<String,String> kafkaTemplate;

    public Producer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }

    public void sendMessage(String message){

        log.info(String.format("Message sent %s",message));
        kafkaTemplate.send("Topic-salah",message);

    }


}
