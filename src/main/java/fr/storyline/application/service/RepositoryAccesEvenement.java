package fr.storyline.application.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.storyline.application.entity.acces.AccesEvenement;

@Repository
public interface RepositoryAccesEvenement extends CrudRepository<AccesEvenement, Long>,
		JpaSpecificationExecutor<AccesEvenement> {

	List<AccesEvenement> findByUtilisateurAndEvenement(Long idUser, Long idEvenement);




}
