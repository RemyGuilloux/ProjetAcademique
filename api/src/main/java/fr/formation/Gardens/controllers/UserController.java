package fr.formation.Gardens.controllers;

import java.util.Set;

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

import fr.formation.Gardens.configuration.SecurityHelper;
import fr.formation.Gardens.dtos.requests.UserInfoCreateDto;
import fr.formation.Gardens.dtos.requests.UserInfoUpdateDto;
import fr.formation.Gardens.dtos.responses.UserInfoViewDto;
import fr.formation.Gardens.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping()
public class UserController {
	private final UserService service;

	protected UserController(UserService service) {
		this.service = service;

	}

	/**
	 * <p>
	 * Returns a pageable containing all users present in database.
	 * </p>
	 * 
	 * @return [ ... UserInfoViewDto ]
	 */
	@GetMapping("secure/users")
	public Set<UserInfoViewDto> getAll() {
		return service.getAll();
	}

	/**
	 * <p>
	 * Returns user matching the given id.
	 * </p>
	 * 
	 * @param
	 * @return UserInfoViewDto
	 */
	@GetMapping("secure/users/{id}")
	public UserInfoViewDto get(@PathVariable("id") Long id) {
		return service.getCurrentUserInfo(id);
	}

	/**
	 * <p>
	 * Persists new user with the given {@code RequestBody}
	 * </p>
	 * 
	 * @param
	 * @return UserInfoViewDto
	 */
	@PostMapping("auth/signup")
	public UserInfoViewDto create(@Valid @RequestBody UserInfoCreateDto dto) {
		return service.create(dto);
	}

	/**
	 * <p>
	 * Update user matching the given id with new informations passed in
	 * {@code RequestBody}
	 * </p>
	 * 
	 * @param
	 * @return UserInfoViewDto
	 */
	@PutMapping("secure/users/{id}")
	public UserInfoViewDto update(@PathVariable("id") Long id, @Valid @RequestBody UserInfoUpdateDto dto) {
		return service.update(id, dto);
	}

	/**
	 * <p>
	 * Delete user matching the given id.
	 * </p>
	 * 
	 * @param
	 * @return void
	 */
	@DeleteMapping("secure/users/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

	@GetMapping("/secure/users/me")
	public UserInfoViewDto userInfo() {
		Long userId = SecurityHelper.getUserId();
		return service.getCurrentUserInfo(userId);
	}

}
