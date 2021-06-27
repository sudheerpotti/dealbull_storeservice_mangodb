package com.dealbab.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dealbab.model.Store;

public interface StoreRepository extends MongoRepository<Store, Integer>{

}
