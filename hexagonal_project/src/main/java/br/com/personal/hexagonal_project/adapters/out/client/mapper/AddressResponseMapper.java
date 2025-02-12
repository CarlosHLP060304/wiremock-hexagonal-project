package br.com.personal.hexagonal_project.adapters.out.client.mapper;

import org.mapstruct.Mapper;

import br.com.personal.hexagonal_project.adapters.out.client.response.AddressResponse;
import br.com.personal.hexagonal_project.application.core.domain.Address;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    Address toAddress(AddressResponse addressResponse);
}