package com.kristinkor.artstore.repository;


import com.kristinkor.artstore.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,String> {
}
