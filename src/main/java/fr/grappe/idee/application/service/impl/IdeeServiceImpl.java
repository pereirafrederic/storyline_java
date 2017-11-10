package fr.grappe.idee.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grappe.idee.application.model.dto.IdeeDTO;
import fr.grappe.idee.application.model.entity.IdeeEntity;
import fr.grappe.idee.application.model.mapper.MapperIdee;
import fr.grappe.idee.application.model.repository.IdeeRepository;
import fr.grappe.idee.application.service.IdeeService;

@Service
public class IdeeServiceImpl implements IdeeService {

	@Autowired
	private IdeeRepository repo;
	
	@Autowired
	private MapperIdee mapper;


	@Override
	public IdeeDTO findOne(Long id, int levelDemande) {
		IdeeEntity idee = repo.findOne(id);
		return mapper.mapperUnitaire(idee, 0, levelDemande);
	}
	

}
