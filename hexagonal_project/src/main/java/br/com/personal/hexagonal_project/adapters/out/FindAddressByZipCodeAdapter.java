package br.com.personal.hexagonal_project.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.personal.hexagonal_project.adapters.out.client.FindAddressByZipCodeClient;
import br.com.personal.hexagonal_project.adapters.out.client.mapper.AddressResponseMapper;
import br.com.personal.hexagonal_project.application.core.domain.Address;
import br.com.personal.hexagonal_project.application.ports.out.FindAddressByZipCodeOutputPort;


@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort{

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
       var addressResponse = findAddressByZipCodeClient.find(zipCode);
       return addressResponseMapper.toAddress(addressResponse);
    }
     
    
}