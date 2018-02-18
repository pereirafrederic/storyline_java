package fr.grappe.idee.application.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.grappe.idee.application.model.entity.AssociationEntity;
import fr.grappe.idee.application.model.entity.IdeeEntity;

@Repository
public interface AssociationRepository
		extends CrudRepository<AssociationEntity, Long>, JpaSpecificationExecutor<AssociationEntity> {

	List<AssociationEntity> findByIdeeMaitreAndIdeeEsclave(IdeeEntity ideeMaitre, IdeeEntity ideeEsclave);

}
