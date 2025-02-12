package br.com.personal.hexagonal_project.application.ports.out;

import java.util.Optional;

import br.com.personal.hexagonal_project.application.core.domain.Customer;

public interface FindCustomerByIdOutputPort {
    Optional<Customer> find(String id);
}