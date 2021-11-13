package fr.formation.Gardens.services;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import fr.formation.Gardens.dtos.GardenerViewDto;
import fr.formation.Gardens.entities.Gardener;
import fr.formation.Gardens.repositories.GardenerJpaRepository;

@Service
public class GardenerServiceImpl implements GardenerService {

	private final GardenerJpaRepository repository;

	private final ModelMapper mapper;

	protected GardenerServiceImpl(GardenerJpaRepository repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public GardenerViewDto getById(Long id) {

		return repository.getById(id);
	}

	@Override
	public List<Gardener> getAllGardeners() {

		return repository.findAll();
	}

	@Override
	public Gardener save(@Valid Gardener gardening) {

		return repository.save(gardening);
	}

	@Override
	public void deleteByid(Long id) {
		repository.deleteById(id);

	}
}
