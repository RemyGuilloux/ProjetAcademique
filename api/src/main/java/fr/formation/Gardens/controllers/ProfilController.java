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

import fr.formation.Gardens.dtos.ProfilCreateDto;
import fr.formation.Gardens.dtos.ProfilViewDto;
import fr.formation.Gardens.entities.Profil;
import fr.formation.Gardens.services.ProfilService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping()
public class ProfilController {
	private final ProfilService service;

	public ProfilController(ProfilService service) {
		this.service = service;
	}

	@GetMapping("/profils/{id}")
	public ProfilViewDto getById(@PathVariable Long id) {
		return service.getById(id);

	}

	@PostMapping("/profils")
	public ProfilCreateDto createProfil(@Valid @RequestBody ProfilCreateDto profil) {
		return service.save(profil);
	}

	@PutMapping("/profils/{id}")
	public Profil updateProfil(@Valid @RequestBody Profil profil) {
		return service.update(profil);
	}

	@DeleteMapping("/profils/{id}")
	public void deleteMatch(@PathVariable Long id) {
		service.deleteByid(id);

	}

	@GetMapping("/profils")
	public List<ProfilViewDto> getAllProfils() {
		return service.getAllProfils();
	}

}
