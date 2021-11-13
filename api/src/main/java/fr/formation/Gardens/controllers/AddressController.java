package fr.formation.Gardens.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.Gardens.dtos.AddressViewDto;
import fr.formation.Gardens.entities.Address;
import fr.formation.Gardens.services.AddressService;

@RestController
@CrossOrigin(origins= "*")
@RequestMapping()
public class AddressController {
	
	private final AddressService service;
	
	public AddressController(AddressService service) {
		this.service = service;
	}

	@GetMapping("/addresses/{id}")
	public AddressViewDto getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@GetMapping("/addresses")
	public List<Address> getALLAddresses(){
		return service.getALLAddresses();
		
	}
	
	@PostMapping("/addresses")
	public Address createAddress(@Valid @RequestBody Address address) {
		return service.save(address);
	}
	@DeleteMapping ("/addresses/{id}")
	public void deleteMatch(@PathVariable Long id) {
		service.deleteById(id);
	}
	@PutMapping("/addresses/{id}")
	public Address updtadeAddress(@Valid @RequestBody Address address) {
		return service.update(address);
	}
}
