package fr.grapidee.application.services.grappe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrappeRepository
		extends CrudRepository<GrappeEntity, Long>, JpaSpecificationExecutor<GrappeEntity> {

	List<GrappeEntity> findByNom(String nomGrappe);

}
