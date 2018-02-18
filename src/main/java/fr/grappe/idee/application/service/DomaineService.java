package fr.grappe.idee.application.service;

import java.util.List;

import fr.grappe.idee.application.model.body.DomaineBodyDTO;
import fr.grappe.idee.application.model.dto.CommunDTO;
import fr.grappe.idee.application.model.dto.DomaineDTO;

public interface DomaineService {

	List<CommunDTO> findAll();

	DomaineDTO findOne(Long id, int niveauInferieur);

	DomaineDTO putOne(DomaineBodyDTO domaine);

	DomaineDTO postOne(DomaineBodyDTO domaine) throws Exception;

	DomaineDTO injecterDomaine(String nom) throws Exception;

}
