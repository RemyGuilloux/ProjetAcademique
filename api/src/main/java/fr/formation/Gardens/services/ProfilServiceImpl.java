package fr.formation.Gardens.services;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import fr.formation.Gardens.dtos.ProfilCreateDto;
import fr.formation.Gardens.dtos.ProfilViewDto;
import fr.formation.Gardens.entities.Profil;
import fr.formation.Gardens.repositories.ProfilJpaRepository;

@Service
public class ProfilServiceImpl implements ProfilService {
	private final ProfilJpaRepository repository;

	private final ModelMapper mapper;

	protected ProfilServiceImpl(ProfilJpaRepository repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public ProfilViewDto getById(Long id) {

		return repository.getById(id);
	}

	@Override
	public List<ProfilViewDto> getAllProfils() {
		return repository.findAllProjectedBy();
	}

	@Override
	public ProfilCreateDto save(ProfilCreateDto inputs) {

		Profil profil = mapper.map(inputs, Profil.class);
		profil = repository.save(profil);
		return mapper.map(profil, ProfilCreateDto.class);
	}

	@Override
	public void deleteByid(Long id) {
		repository.deleteById(id);

	}

	@Override
	public Profil update(@Valid Profil profil) {

		Profil profileUp = new Profil();

		profileUp.setMail(profil.getMail());
		profileUp.setLastname(profil.getLastname());
		profileUp.setName(profil.getName());
		profileUp.setGender(profil.getGender());
		profileUp.setPhone(profil.getPhone());
		return profileUp;
	}

}
