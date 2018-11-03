package fr.grapidee.application.services.domaine;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineRepository
		extends CrudRepository<DomaineEntity, Long>, JpaSpecificationExecutor<DomaineEntity> {

	List<DomaineEntity> findByNom(String nom);

}
