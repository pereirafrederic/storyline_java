package fr.grappe.idee.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grappe.idee.application.model.dto.CommunDTO;
import fr.grappe.idee.application.model.dto.GrappeDTO;
import fr.grappe.idee.application.model.entity.AssociationEntity;
import fr.grappe.idee.application.model.entity.GrappeEntity;
import fr.grappe.idee.application.model.entity.IdeeEntity;
import fr.grappe.idee.application.model.mapper.MapperCombox;
import fr.grappe.idee.application.model.mapper.MapperGrappe;
import fr.grappe.idee.application.model.mapper.MapperIdee;
import fr.grappe.idee.application.model.repository.GrappeRepository;
import fr.grappe.idee.application.service.GrappeService;

@Service
public class GrappeServiceImpl implements GrappeService {

	@Autowired
	private GrappeRepository repo;

	@Autowired
	private MapperCombox mapperCombo;
	
@Autowired
private MapperGrappe mapperGrappe;

	@Override
	public List<CommunDTO> findAll() {
		Iterable<GrappeEntity> listeGrappe = repo.findAll();
		return mapperCombo.mapperGrappe((List<GrappeEntity>) listeGrappe);
	}

	@Override
	public GrappeDTO findOne(Long id) {
		
		GrappeEntity grappe = repo.findOne(id);
		GrappeDTO retour = mapperGrappe.mapperUnitaire(grappe);
		
		return retour;
	}


}
