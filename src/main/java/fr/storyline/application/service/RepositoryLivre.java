package fr.storyline.application.service;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.storyline.application.entity.contenu.Livre;

@Repository
public interface RepositoryLivre extends CrudRepository<Livre, Long>,
		JpaSpecificationExecutor<Livre> {


}
