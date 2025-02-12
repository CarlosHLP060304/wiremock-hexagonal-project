package br.com.personal.hexagonal_project.application.ports.out;

import br.com.personal.hexagonal_project.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
    void insert(Customer customer);
}
