package fr.storyline.application.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.storyline.application.entity.user.Utilisateur;


@Repository
public interface RepositoryUtilisateur extends CrudRepository<Utilisateur, Long>,
		JpaSpecificationExecutor<Utilisateur> {

	List<Utilisateur> findByPseudo(String pseudo);
	List<Utilisateur> findByEmail( String email);


}
