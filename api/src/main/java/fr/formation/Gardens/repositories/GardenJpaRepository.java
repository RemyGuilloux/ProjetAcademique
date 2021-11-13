package fr.formation.Gardens.repositories;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.Gardens.dtos.GardenViewDto;
import fr.formation.Gardens.entities.Garden;

@Repository
public interface GardenJpaRepository extends JpaRepository<Garden, Long> {
	GardenViewDto getById(Long id);

	List<GardenViewDto> findAllProjectedBy();

	GardenViewDto save(@Valid GardenViewDto garden);
}
