package br.com.personal.hexagonal_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.personal.hexagonal_project.adapters.out.DeleteCustomerByIdAdapter;
import br.com.personal.hexagonal_project.application.core.usecase.DeleteCustomerByIdUseCase;
import br.com.personal.hexagonal_project.application.core.usecase.FindCustomerByIdUseCase;

@Configuration
public class DeleteCustomerByIdConfig {
    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
        FindCustomerByIdUseCase findCustomerByIdUseCase,
        DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ){
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase,deleteCustomerByIdAdapter);
    } 
}
