package fr.formation.Gardens.services;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import fr.formation.Gardens.dtos.AddressViewDto;
import fr.formation.Gardens.entities.Address;
import fr.formation.Gardens.repositories.AddressJpaRepository;

@Service
public class AddressServiceImpl implements AddressService {
	
	private final AddressJpaRepository repository;
	
	private final ModelMapper mapper;
	
	protected  AddressServiceImpl(AddressJpaRepository repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public AddressViewDto getById(Long id) {
		
		return repository.getById(id) ;
	}

	@Override
	public List<Address> getALLAddresses() {
		
		return repository.findAll();
	}

	@Override
	public Address save(@Valid Address address) {
		
		return repository.save(address);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public Address update(@Valid Address address) {
		// TODO Auto-generated method stub
		return null;
	}

}
