package fr.pereirafrederic.storyline.application.service;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.pereirafrederic.storyline.application.entity.user.Utilisateur;

@Repository
public interface RepositoryUtilisateur extends CrudRepository<Utilisateur, Long>,
		JpaSpecificationExecutor<Utilisateur> {


}
