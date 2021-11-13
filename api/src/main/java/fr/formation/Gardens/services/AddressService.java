package fr.formation.Gardens.services;

import java.util.List;

import javax.validation.Valid;

import fr.formation.Gardens.dtos.AddressViewDto;
import fr.formation.Gardens.entities.Address;

public interface AddressService {

	AddressViewDto getById(Long id);

	List<Address> getALLAddresses();

	Address save(@Valid Address address);

	void deleteById(Long id);

	Address update(@Valid Address address);

}
