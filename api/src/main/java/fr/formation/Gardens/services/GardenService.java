package fr.formation.Gardens.services;

import java.util.List;

import javax.validation.Valid;

import fr.formation.Gardens.dtos.GardenViewDto;
import fr.formation.Gardens.dtos.UpdateGardenDto;
import fr.formation.Gardens.entities.Garden;

public interface GardenService {

	GardenViewDto getById(Long id);

	GardenViewDto save(@Valid GardenViewDto garden);

	List<GardenViewDto> getAllGardens();

	void deleteById(Long id);

	Garden update(Long id, @Valid UpdateGardenDto garden);

	Garden save(@Valid Garden garden);

}
