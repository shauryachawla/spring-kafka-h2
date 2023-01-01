package com.example.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.consumer.dto.TestRequestDTO;
import com.example.consumer.entity.TestRequestEntity;
import com.example.consumer.repo.ItemRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class KafkaService {

    static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    ItemRepo repo;

    @KafkaListener(topics = {"shaurya"}, groupId = "createRequest")
    public void consume(String json) throws JsonMappingException, JsonProcessingException {
        TestRequestDTO dto = mapper.readValue(json, TestRequestDTO.class);
        repo.save(TestRequestEntity.builder().age(dto.getAge()).name(dto.getName()).build());
        System.out.println(json);
    }

    
}
