package br.com.personal.hexagonal_project.application.ports.out;

public interface SendCpfForValidationOutputPort {
   void send(String cpf);
}
