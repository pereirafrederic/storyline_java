package fr.grapidee.application.services.idee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeeRepository
		extends CrudRepository<IdeeEntity, Long>, JpaSpecificationExecutor<IdeeEntity> {

	List<IdeeEntity> findByNom(String nomMaitre);

	IdeeEntity findById(Long id);

}
