package br.com.personal.hexagonal_project.application.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.personal.hexagonal_project.application.ports.in.DeleteCustomerByIdInputPort;
import br.com.personal.hexagonal_project.application.ports.in.FindCustomerByIdInputPort;
import br.com.personal.hexagonal_project.application.ports.out.DeleteCustomerByOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort{
    
    @Autowired
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private final DeleteCustomerByOutputPort deleteCustomerByOutputPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, DeleteCustomerByOutputPort deleteCustomerByOutputPort){
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByOutputPort = deleteCustomerByOutputPort;
    }

    @Override
    public void delete(String id){
        findCustomerByIdInputPort.find(id);
        deleteCustomerByOutputPort.delete(id);
    }
}
