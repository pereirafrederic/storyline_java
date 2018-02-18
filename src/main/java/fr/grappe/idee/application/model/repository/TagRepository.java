package fr.grappe.idee.application.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.grappe.idee.application.model.entity.TagEntity;

@Repository
public interface TagRepository
		extends CrudRepository<TagEntity, Long>, JpaSpecificationExecutor<TagEntity> {

	List<TagEntity> findByNom(String nomTag);

}
