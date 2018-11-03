package fr.grapidee.application.services.tag;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository
		extends CrudRepository<TagEntity, Long>, JpaSpecificationExecutor<TagEntity> {

	List<TagEntity> findByNom(String nomTag);

}
