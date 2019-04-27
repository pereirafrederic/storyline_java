package fr.storyline.application.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.storyline.application.entity.contenu.Evenement;

@Repository
public interface RepositoryEvenement extends CrudRepository<Evenement, Long>,
		JpaSpecificationExecutor<Evenement> {

	List<Evenement> findByTempsAndEspace(Long idTemps, Long idEspace);
}
