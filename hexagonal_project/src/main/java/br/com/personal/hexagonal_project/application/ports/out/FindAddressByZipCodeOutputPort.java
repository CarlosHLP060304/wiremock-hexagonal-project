package br.com.personal.hexagonal_project.application.ports.out;

import br.com.personal.hexagonal_project.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
     Address find(String zipCode);
}
