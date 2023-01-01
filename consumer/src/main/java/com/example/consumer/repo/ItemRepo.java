package com.example.consumer.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.consumer.entity.TestRequestEntity;

//Remove @RepositoryRestResource below to disable auto REST api:

public interface ItemRepo extends CrudRepository<TestRequestEntity, String> {
}