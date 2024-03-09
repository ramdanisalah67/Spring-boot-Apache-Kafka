package com.example.demoapachekafka.kafka;


import com.example.demoapachekafka.Models.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
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

    public void sendProduct(Product product){

        log.info(String.format("Product sent %s",product));
        Message<Product> message = MessageBuilder
                .withPayload(product)
                .setHeader(KafkaHeaders.TOPIC,"Topic-salah")
                .build();

        kafkaTemplate.send(message);
    }


}
