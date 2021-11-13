package fr.formation.Gardens.services;

import java.util.List;

import fr.formation.Gardens.dtos.ProfilCreateDto;
import fr.formation.Gardens.dtos.ProfilViewDto;
import fr.formation.Gardens.entities.Profil;

public interface ProfilService {
	ProfilViewDto getById(Long id);

	List<ProfilViewDto> getAllProfils();

	ProfilCreateDto save(ProfilCreateDto profil);

	void deleteByid(Long id);

	Profil update(Profil profil);

}
