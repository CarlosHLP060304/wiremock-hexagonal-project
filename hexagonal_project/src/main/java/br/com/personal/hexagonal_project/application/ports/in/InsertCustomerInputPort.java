package br.com.personal.hexagonal_project.application.ports.in;

import br.com.personal.hexagonal_project.application.core.domain.Customer;

public interface InsertCustomerInputPort  {
    void insert(Customer customer, String zipCode);
}
