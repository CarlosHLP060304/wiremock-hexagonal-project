package br.com.personal.hexagonal_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.personal.hexagonal_project.adapters.out.FindAddressByZipCodeAdapter;
import br.com.personal.hexagonal_project.adapters.out.InsertCustomerAdapter;
import br.com.personal.hexagonal_project.adapters.out.SendCpfForValidationAdapter;
import br.com.personal.hexagonal_project.application.core.usecase.InsertCustomerUseCase;
import br.com.personal.hexagonal_project.application.ports.out.SendCpfForValidationOutputPort;

@Configuration
public class InsertCustomerConfig {
    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
        FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
        InsertCustomerAdapter insertCustomerAdapter,
        SendCpfForValidationAdapter sendCpfForValidationAdapter
        ){
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter,insertCustomerAdapter,sendCpfForValidationAdapter);
    }
}
