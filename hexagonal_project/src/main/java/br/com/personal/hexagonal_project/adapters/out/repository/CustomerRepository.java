package br.com.personal.hexagonal_project.adapters.out.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.personal.hexagonal_project.adapters.out.repository.entity.CustomerEntity;

public interface CustomerRepository extends MongoRepository<CustomerEntity,String> {
    
}
