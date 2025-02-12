package br.com.personal.hexagonal_project.application.core.usecase;

import org.springframework.stereotype.Component;

import br.com.personal.hexagonal_project.application.core.domain.Customer;
import br.com.personal.hexagonal_project.application.ports.in.FindCustomerByIdInputPort;
import br.com.personal.hexagonal_project.application.ports.out.FindCustomerByIdOutputPort;

@Component
public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort{

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;


    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort){
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }
    
    @Override
    public Customer find(String id){
        return findCustomerByIdOutputPort.find(id).orElseThrow(
            ()-> new RuntimeException(id)
        );
    };
}
