package br.com.personal.hexagonal_project.adapters.in.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import br.com.personal.hexagonal_project.adapters.in.consumer.mapper.CustomerMessageMapper;
import br.com.personal.hexagonal_project.adapters.in.consumer.message.CustomerMessage;
import br.com.personal.hexagonal_project.application.ports.in.UpdateCustomerInputPort;

public class ReceiveValidatedCpfConsumer {
    
    @Autowired 
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics="tp-cpf-validated",groupId="arantes")
    public void receive(CustomerMessage customerMessage){
        var customer =  customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
