package fr.grappe.idee.application.service;

import java.util.List;

import fr.grappe.idee.application.model.dto.CommunDTO;
import fr.grappe.idee.application.model.dto.GrappeDTO;

public interface GrappeService {

	List<CommunDTO> findAll();

	GrappeDTO findOne(Long id);

}
