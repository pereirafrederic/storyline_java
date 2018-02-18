package fr.grappe.idee.application.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.grappe.idee.application.model.entity.GrappeEntity;

@Repository
public interface GrappeRepository
		extends CrudRepository<GrappeEntity, Long>, JpaSpecificationExecutor<GrappeEntity> {

	List<GrappeEntity> findByNom(String nomGrappe);

}
