package fr.grappe.idee.application.model.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.grappe.idee.application.model.entity.IdeeEntity;

@Repository
public interface IdeeRepository
		extends CrudRepository<IdeeEntity, Long>, JpaSpecificationExecutor<IdeeEntity> {

}
