package br.com.personal.hexagonal_project.application.core.usecase;


import br.com.personal.hexagonal_project.application.core.domain.Customer;
import br.com.personal.hexagonal_project.application.ports.in.FindCustomerByIdInputPort;
import br.com.personal.hexagonal_project.application.ports.in.UpdateCustomerInputPort;
import br.com.personal.hexagonal_project.application.ports.out.FindAddressByZipCodeOutputPort;

import br.com.personal.hexagonal_project.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodePort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(
    FindCustomerByIdInputPort findCustomerByIdInputPort,
    FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
    UpdateCustomerOutputPort updateCustomerOutputPort
    ) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodePort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }
    @Override
    public void update(Customer customer,String zipCode){
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodePort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
