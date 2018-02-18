package fr.grappe.idee.application.service;

import java.util.List;

import fr.grappe.idee.application.model.body.GrappeBodyDTO;
import fr.grappe.idee.application.model.dto.CommunDTO;
import fr.grappe.idee.application.model.dto.GrappeDTO;

public interface GrappeService {

	List<CommunDTO> findAll();

	GrappeDTO findOne(Long id, int niveauInferieur);

	GrappeDTO putOne(GrappeBodyDTO grappe);

	GrappeDTO postOne(GrappeBodyDTO grappe);

	GrappeDTO injecterGrappe(String nom, String domaine) throws Exception;

}
