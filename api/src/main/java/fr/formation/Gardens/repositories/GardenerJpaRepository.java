package fr.formation.Gardens.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.Gardens.dtos.GardenerViewDto;
import fr.formation.Gardens.entities.Gardener;

@Repository
public interface GardenerJpaRepository extends JpaRepository<Gardener, Long> {
	GardenerViewDto getById(Long id);
}
