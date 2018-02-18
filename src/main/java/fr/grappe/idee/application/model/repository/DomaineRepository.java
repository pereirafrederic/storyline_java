package fr.grappe.idee.application.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.grappe.idee.application.model.entity.DomaineEntity;

@Repository
public interface DomaineRepository
		extends CrudRepository<DomaineEntity, Long>, JpaSpecificationExecutor<DomaineEntity> {

	List<DomaineEntity> findByNom(String nom);

}
