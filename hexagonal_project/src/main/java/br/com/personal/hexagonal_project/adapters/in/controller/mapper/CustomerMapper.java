package br.com.personal.hexagonal_project.adapters.in.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.personal.hexagonal_project.adapters.in.controller.request.CustomerRequest;
import br.com.personal.hexagonal_project.adapters.in.controller.response.CustomerResponse;
import br.com.personal.hexagonal_project.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer); 
}
