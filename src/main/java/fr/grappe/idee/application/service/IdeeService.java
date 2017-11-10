package fr.grappe.idee.application.service;

import fr.grappe.idee.application.model.dto.IdeeDTO;

public interface IdeeService {

	IdeeDTO findOne(Long id, int levelDemande);

}
