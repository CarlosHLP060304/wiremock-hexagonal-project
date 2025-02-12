package br.com.personal.hexagonal_project.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import br.com.personal.hexagonal_project.adapters.out.repository.entity.CustomerEntity;
import br.com.personal.hexagonal_project.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper{
    CustomerEntity toCustomerEntity(Customer customer);
    Customer toCustomer(CustomerEntity customerEntity);
}
