package fr.formation.Gardens.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.Gardens.dtos.GardenerViewDto;
import fr.formation.Gardens.entities.Gardener;
import fr.formation.Gardens.exceptions.ResourceNotFoundException;
import fr.formation.Gardens.services.GardenerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping()
public class GardenerController {

	private final GardenerService service;

	public GardenerController(GardenerService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public GardenerViewDto getById(@PathVariable Long id) throws ResourceNotFoundException {
		return service.getById(id);
	}

	@GetMapping("/gardeners")
	public List<Gardener> getAllGardeners() throws ResourceNotFoundException {
		return service.getAllGardeners();
	}

	@PostMapping("/gardeners")
	public Gardener createGardening(@Valid @RequestBody Gardener gardener) {
		return service.save(gardener);
	}

	@DeleteMapping("/{id}")
	public void deleteMatch(@PathVariable Long id) throws ResourceNotFoundException {
		service.deleteByid(id);
	}
}