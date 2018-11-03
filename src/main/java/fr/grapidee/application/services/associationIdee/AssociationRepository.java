package fr.grapidee.application.services.associationIdee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.grapidee.application.services.idee.IdeeEntity;

@Repository
public interface AssociationRepository
		extends CrudRepository<AssociationEntity, Long>, JpaSpecificationExecutor<AssociationEntity> {

	List<AssociationEntity> findByIdeeMaitreAndIdeeEsclave(IdeeEntity ideeMaitre, IdeeEntity ideeEsclave);

}
