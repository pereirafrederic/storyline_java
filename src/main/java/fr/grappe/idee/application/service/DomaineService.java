package fr.grappe.idee.application.service;

import java.util.List;

import fr.grappe.idee.application.model.dto.CommunDTO;
import fr.grappe.idee.application.model.dto.DomaineDTO;
import fr.grappe.idee.application.model.dto.GrappeDTO;

public interface DomaineService {

	List<CommunDTO> findAll();

	DomaineDTO findOne(Long id);

}
