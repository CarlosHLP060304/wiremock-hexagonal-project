package br.com.personal.hexagonal_project.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.personal.hexagonal_project.adapters.out.repository.CustomerRepository;
import br.com.personal.hexagonal_project.application.ports.out.DeleteCustomerByOutputPort;


@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByOutputPort{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
       customerRepository.deleteById(id);
    }
    
}
