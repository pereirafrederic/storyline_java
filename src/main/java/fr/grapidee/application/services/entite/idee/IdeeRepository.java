package fr.grapidee.application.services.entite.idee;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeeRepository
		extends CrudRepository<IdeeEntity, Long>, JpaSpecificationExecutor<IdeeEntity> {

}
