package br.com.personal.hexagonal_project.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.personal.hexagonal_project.adapters.out.repository.CustomerRepository;
import br.com.personal.hexagonal_project.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.personal.hexagonal_project.application.core.domain.Customer;
import br.com.personal.hexagonal_project.application.ports.out.InsertCustomerOutputPort;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort{
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
       var customerEntity =  customerEntityMapper.toCustomerEntity(customer);
       customerRepository.save(customerEntity);
    }
    
}
