package br.com.personal.hexagonal_project.adapters.out.repository.entity;

import lombok.Data;

@Data
public class AddressEntity {
    private String street;

    private String city;

    private String state;
}
