package fr.grapidee.application.services.domaine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.grapidee.application.services.commun.CommunDTO;
import fr.grapidee.application.services.commun.MapperCombox;

@Service
public class DomaineService {

	@Autowired
	private DomaineRepository repo;

	@Autowired
	private MapperCombox mapperCombo;
	
	@Autowired
	private MapperDomaine mapperDomaine;

	
	@Transactional(readOnly=true)
	public List<CommunDTO> findAll() {
		Iterable<DomaineEntity> listeDomaine = repo.findAll();		
		return mapperCombo.mapperDomaine((List<DomaineEntity>)listeDomaine);
	}

	
	@Transactional(readOnly=true)
	public DomaineDTO findOne(Long id, int niveauInferieur) {
		
		DomaineEntity domaine = repo.findOne(id);
		List<Long> listeIdee = new ArrayList<>();
		DomaineDTO retour = mapperDomaine.mapperUnitaire(domaine,0, niveauInferieur, listeIdee);
		return retour;
	}

	
	@Transactional(propagation= Propagation.MANDATORY)
	public DomaineDTO putOne(DomaineBodyDTO domaineDto) throws Exception {
		DomaineEntity domaineEntity =repo.findOne(domaineDto.getId());
		if( null == domaineEntity)
		{
			throw new Exception("le domaine "+ domaineDto.getId()+ " existe pas.");
		}
		return mapperAndSaveAndMapper(domaineEntity,domaineDto);
	}

	
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
		return this.findOne(retourEntity.getId(), 3);
	}

	
}
