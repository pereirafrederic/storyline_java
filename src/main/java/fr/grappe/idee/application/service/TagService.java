package fr.grappe.idee.application.service;

import java.util.List;

import fr.grappe.idee.application.model.body.TagBodyDTO;
import fr.grappe.idee.application.model.dto.CommunDTO;
import fr.grappe.idee.application.model.dto.TagDTO;

public interface TagService {

	List<CommunDTO> findAll();

	TagDTO findOne(Long id, int niveauInferieur);

	TagDTO putOne(TagBodyDTO tag);

	TagDTO postOne(TagBodyDTO tag);

	TagDTO injecterTag(String nom, String grappe) throws Exception;

}
