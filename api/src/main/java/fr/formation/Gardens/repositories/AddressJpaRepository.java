package fr.formation.Gardens.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.Gardens.dtos.AddressViewDto;
import fr.formation.Gardens.entities.Address;

public interface AddressJpaRepository extends JpaRepository<Address, Long> {
	AddressViewDto getById(Long id);

}
