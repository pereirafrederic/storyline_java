package fr.grappe.idee.application.service;

import fr.grappe.idee.application.model.body.IdeeBodyDTO;
import fr.grappe.idee.application.model.dto.IdeeDTO;

public interface IdeeService {

	IdeeDTO findOne(Long id, int levelDemande);

	IdeeDTO putOne(IdeeBodyDTO idee);

	IdeeDTO postOne(IdeeBodyDTO idee);

	IdeeDTO injecterIdee(String nom, String contenu, String tag) throws Exception;

}
