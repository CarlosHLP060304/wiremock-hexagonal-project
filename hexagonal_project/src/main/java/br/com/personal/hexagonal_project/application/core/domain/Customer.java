package br.com.personal.hexagonal_project.application.core.domain;


public class Customer {
    private String id;
    private String name;
    private Address address;
    private String cpf;
    private Boolean isValidCpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
  

    public Customer(){
        this.isValidCpf = false;
    }

    public Customer(String id, String name, Address address,String cpf ,Boolean isValidCpf) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.isValidCpf = isValidCpf;
        this.cpf = cpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getIsValidCpf() {
        return isValidCpf;
    }

    public void setIsValidCpf(Boolean isValidCpf) {
        this.isValidCpf = isValidCpf;
    }

}
