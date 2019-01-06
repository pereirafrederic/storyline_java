package fr.grapidee.application.services.entite.grappe;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrappeRepository
		extends CrudRepository<GrappeEntity, Long>, JpaSpecificationExecutor<GrappeEntity> {

}
