package fr.grappe.idee.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.grappe.idee.application.model.body.DomaineBodyDTO;
import fr.grappe.idee.application.model.dto.CommunDTO;
import fr.grappe.idee.application.model.dto.DomaineDTO;
import fr.grappe.idee.application.model.entity.DomaineEntity;
import fr.grappe.idee.application.model.mapper.MapperCombox;
import fr.grappe.idee.application.model.mapper.MapperDomaine;
import fr.grappe.idee.application.model.repository.DomaineRepository;
import fr.grappe.idee.application.service.DomaineService;

@Service
public class DomaineServiceImpl implements DomaineService {

	@Autowired
	private DomaineRepository repo;

	@Autowired
	private MapperCombox mapperCombo;
	
	@Autowired
	private MapperDomaine mapperDomaine;

	@Override
	@Transactional(readOnly=true)
	public List<CommunDTO> findAll() {
		Iterable<DomaineEntity> listeDomaine = repo.findAll();		
		return mapperCombo.mapperDomaine((List<DomaineEntity>)listeDomaine);
	}

	@Override
	@Transactional(readOnly=true)
	public DomaineDTO findOne(Long id, int niveauInferieur) {
		
		DomaineEntity domaine = repo.findOne(id);
		List<Long> listeIdee = new ArrayList<>();
		DomaineDTO retour = mapperDomaine.mapperUnitaire(domaine,0, niveauInferieur, listeIdee);
		return retour;
	}

	@Override
	@Transactional(propagation= Propagation.MANDATORY)
	public DomaineDTO putOne(DomaineBodyDTO domaineDto) {
		DomaineEntity domaineEntity =repo.findOne(domaineDto.getId());
		return mapperAndSaveAndMapper(domaineEntity,domaineDto);
	}

	@Override
	@Transactional(propagation= Propagation.MANDATORY)
	public DomaineDTO postOne(DomaineBodyDTO domaineDto) throws Exception {
		DomaineEntity domaineEntity = new DomaineEntity();
		
		List<DomaineEntity> listeTrouve=	repo.findByNom(domaineDto.getNom());
		if(listeTrouve.isEmpty())
		{
		return mapperAndSaveAndMapper(domaineEntity, domaineDto);  
		}
		else
		{
			throw new Exception("le domaine "+ domaineDto.getNom()+ " existe déjà.");
		}
	}

	private DomaineDTO mapperAndSaveAndMapper(DomaineEntity domaineEntity, DomaineBodyDTO domaineDto) {
		domaineEntity.setNom(domaineDto.getNom());
		DomaineEntity retourEntity =repo.save(domaineEntity);
		return this.findOne(retourEntity.getId(), 0);
	}

	@Override
	public DomaineDTO injecterDomaine(String nom) throws Exception {
		DomaineBodyDTO domaineDto = new DomaineBodyDTO();
		domaineDto.setNom(nom);
		return postOne(domaineDto);
	}
}
