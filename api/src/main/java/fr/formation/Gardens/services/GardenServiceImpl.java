package fr.formation.Gardens.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import fr.formation.Gardens.dtos.GardenViewDto;
import fr.formation.Gardens.dtos.UpdateGardenDto;
import fr.formation.Gardens.entities.Garden;
import fr.formation.Gardens.exceptions.ResourceNotFoundException;
import fr.formation.Gardens.repositories.AddressJpaRepository;
import fr.formation.Gardens.repositories.GardenJpaRepository;
import fr.formation.Gardens.repositories.ProfilJpaRepository;

@Service
public class GardenServiceImpl implements GardenService {

	private final GardenJpaRepository repository;
	private final ProfilJpaRepository repo;
	private final AddressJpaRepository repoAd;

	private final ModelMapper mapper;

	protected GardenServiceImpl(GardenJpaRepository repository, ProfilJpaRepository repo, AddressJpaRepository repoAd,
			ModelMapper mapper) {
		this.repository = repository;
		this.repo = repo;
		this.repoAd = repoAd;
		this.mapper = mapper;

	}

	@Override
	public GardenViewDto getById(Long id) {
		return repository.getById(id);
	}

	@Override
	public GardenViewDto save(@Valid GardenViewDto garden) {

		return repository.save(garden);
	}

	@Override
	public List<GardenViewDto> getAllGardens() {
		return repository.findAllProjectedBy();
	}

	@Override
	public void deleteById(Long id) {

		Optional<Garden> gardenDelete = repository.findById(id);
		Garden toBeDeleted = gardenDelete.orElseThrow(() -> new ResourceNotFoundException());
		repository.delete(toBeDeleted);

	}

	@SuppressWarnings("unused")
	@Override
	public Garden update(@PathVariable(value = "id") Long id, @Valid @RequestBody UpdateGardenDto garden) {
		Optional<Garden> gardenUpdate = repository.findById(id);
		gardenUpdate.ifPresent(elt -> mapper.map(garden, elt));
		Garden savedGarden = gardenUpdate
				.orElseThrow(() -> new ResourceNotFoundException("Garden not found with id " + id));
		return repository.save(savedGarden);

	}

	@Override
	public Garden save(@Valid Garden garden) {
		return repository.save(garden);
	}

}