package fr.grappe.idee.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grappe.idee.application.model.dto.CommunDTO;
import fr.grappe.idee.application.model.dto.DomaineDTO;
import fr.grappe.idee.application.model.dto.GrappeDTO;
import fr.grappe.idee.application.model.entity.DomaineEntity;
import fr.grappe.idee.application.model.entity.GrappeEntity;
import fr.grappe.idee.application.model.mapper.MapperCombox;
import fr.grappe.idee.application.model.mapper.MapperDomaine;
import fr.grappe.idee.application.model.mapper.MapperIdee;
import fr.grappe.idee.application.model.repository.DomaineRepository;
import fr.grappe.idee.application.model.repository.GrappeRepository;
import fr.grappe.idee.application.service.DomaineService;
import fr.grappe.idee.application.service.GrappeService;

@Service
public class DomaineServiceImpl implements DomaineService {

	@Autowired
	private DomaineRepository repo;

	@Autowired
	private MapperCombox mapperCombo;
	
	@Autowired
	private MapperDomaine mapperDomaine;

	@Override
	public List<CommunDTO> findAll() {
		Iterable<DomaineEntity> listeDomaine = repo.findAll();		
		return mapperCombo.mapperDomaine((List<DomaineEntity>)listeDomaine);
	}

	@Override
	public DomaineDTO findOne(Long id) {
		
		DomaineEntity domaine = repo.findOne(id);
		DomaineDTO retour = mapperDomaine.mapperUnitaire(domaine);
		return retour;
	}
}
