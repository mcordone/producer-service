package com.stream.producer.controller;

import com.stream.producer.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @PostMapping(value = "publish")
    public String publishToKafka(@RequestBody String message){
        log.info("*** Message: " + message);

        producerService.publishMessage(message);
        return "OK";

    }
}
