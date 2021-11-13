package fr.formation.Gardens.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.Gardens.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByCode(String string);
}
