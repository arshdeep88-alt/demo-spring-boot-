package com.demo.demo1.repository;

import com.demo.demo1.entity.demoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface demoRepo extends MongoRepository<demoEntity, Integer> {
}
