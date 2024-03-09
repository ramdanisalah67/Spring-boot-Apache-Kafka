package com.example.demoapachekafka.Controllers;


import com.example.demoapachekafka.Models.Product;
import com.example.demoapachekafka.kafka.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TestCoontroller {

    private final Producer producer;


    @GetMapping("send")
    public ResponseEntity<String> saveMessageToTopic(@RequestParam String message){

        producer.sendMessage(message);
        return ResponseEntity.ok("message saved to kafka Topic !!!");
    }

    @GetMapping("sendProduct")
    public ResponseEntity<String> saveProductToTopic(){
        Product product = new Product(UUID.randomUUID().toString(),"", BigDecimal.valueOf(152));
        producer.sendProduct(product);
        return ResponseEntity.ok("Product saved to kafka Topic !!!");
    }

}
