package br.com.personal.hexagonal_project.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import br.com.personal.hexagonal_project.application.ports.out.SendCpfForValidationOutputPort;

@Component
public class SendCpfForValidationAdapter implements  SendCpfForValidationOutputPort {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public void send(String cpf){
        kafkaTemplate.send("tp-cpf-validation",cpf);
    }
}
