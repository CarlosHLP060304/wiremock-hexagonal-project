package br.com.personal.hexagonal_project.adapters.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.personal.hexagonal_project.adapters.in.controller.mapper.CustomerMapper;
import br.com.personal.hexagonal_project.adapters.in.controller.request.CustomerRequest;
import br.com.personal.hexagonal_project.adapters.in.controller.response.CustomerResponse;
import br.com.personal.hexagonal_project.application.core.domain.Customer;
import br.com.personal.hexagonal_project.application.ports.in.FindCustomerByIdInputPort;
import br.com.personal.hexagonal_project.application.ports.in.InsertCustomerInputPort;
import br.com.personal.hexagonal_project.application.ports.in.UpdateCustomerInputPort;
import br.com.personal.hexagonal_project.application.ports.out.DeleteCustomerByOutputPort;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    
    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;
    
    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;
    
    @Autowired
    private DeleteCustomerByOutputPort deleteCustomerByOutputPort;

    @Autowired
    private CustomerMapper customerMapper;

    

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
        Customer customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer,customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
        Customer customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok(customerResponse);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest){
        Customer customer =  customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());        
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id){
        deleteCustomerByOutputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
