package com.example.producer.controller;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.producer.dto.TestRequest;



@RestController
@RequestMapping("/api")
class resourceNameController {

    @Autowired
    KafkaTemplate<String, TestRequest> kafkaTemplate;

    @PostMapping
    public String create(@RequestBody TestRequest item) {

        ProducerRecord record = new ProducerRecord<String, TestRequest>("shaurya", "createRequest", item);
        try {
            kafkaTemplate.send(record);
            return "record pushed successfully";
        } catch (Exception e) {
            return "record failed to send";
        }
    }

    // @DeleteMapping("{id}")
    // public ResponseEntity<HttpStatus> delete(@PathVariable("id") entityIdType id) {
    //     try {
    //         repository.deleteById(id);
    //         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    //     }
    // }
}