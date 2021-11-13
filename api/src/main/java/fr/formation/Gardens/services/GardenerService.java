package fr.formation.Gardens.services;

import java.util.List;

import javax.validation.Valid;

import fr.formation.Gardens.dtos.GardenerViewDto;
import fr.formation.Gardens.entities.Gardener;

public interface GardenerService {

	GardenerViewDto getById(Long id);

	List<Gardener> getAllGardeners();

	Gardener save(@Valid Gardener gardening);

	void deleteByid(Long id);

}
