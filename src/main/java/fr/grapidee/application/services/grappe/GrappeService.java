package fr.grapidee.application.services.grappe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.grapidee.application.services.commun.CommunDTO;
import fr.grapidee.application.services.commun.MapperCombox;
import fr.grapidee.application.services.domaine.DomaineDTO;
import fr.grapidee.application.services.domaine.DomaineEntity;
import fr.grapidee.application.services.domaine.DomaineRepository;
import fr.grapidee.application.services.domaine.DomaineService;

@Service
public class GrappeService {

	@Autowired
	private GrappeRepository repo;

	@Autowired
	private DomaineRepository domaineRepo;

	@Autowired
	private MapperCombox mapperCombo;

	@Autowired
	private MapperGrappe mapperGrappe;

	@Autowired
	private DomaineService domaineService;

	@Transactional(readOnly = true)
	public List<CommunDTO> findAll() {
		Iterable<GrappeEntity> listeGrappe = repo.findAll();
		return mapperCombo.mapperGrappe((List<GrappeEntity>) listeGrappe);
	}

	
	@Transactional(readOnly = true)
	public GrappeDTO findOne(Long id, int niveauInferieur) {

		GrappeEntity grappe = repo.findOne(id);
		List<Long> listeIdee = new ArrayList<>();
		GrappeDTO retour = mapperGrappe.mapperUnitaire(grappe, 0, niveauInferieur, listeIdee);

		return retour;
	}

	
	@Transactional(propagation = Propagation.MANDATORY)
	public GrappeDTO putOne(GrappeBodyDTO grappeDto) throws Exception {
		GrappeEntity grappeEntity = repo.findOne(grappeDto.getId());
		if( null == grappeEntity)
		{
			throw new Exception("la grappe "+ grappeDto.getId()+ " existe pas.");
		}
		return mapperAndSaveAndMapper(grappeEntity, grappeDto);
	}

	
	@Transactional(propagation = Propagation.MANDATORY)
	public GrappeDTO postOne(GrappeBodyDTO grappeDto) throws Exception {
		
		GrappeEntity grappeEntity = new GrappeEntity();
		
		List<GrappeEntity> listeTrouve=	repo.findByNom(grappeDto.getNom());
		if(listeTrouve.isEmpty())
		{
		return mapperAndSaveAndMapper(grappeEntity, grappeDto);  
		}
		else
		{
			throw new Exception("le domaine "+ grappeDto.getNom()+ " existe déjà.");
		}
		
	
	}



	private GrappeDTO mapperAndSaveAndMapper(GrappeEntity grappeEntity, GrappeBodyDTO grappeDto) {
		grappeEntity.setNom(grappeDto.getNom());
		if (null != grappeDto.getIdDomaine()) {
			grappeEntity.setDomaine(domaineRepo.findOne(grappeDto.getIdDomaine()));
		}
		GrappeEntity retourEntity = repo.save(grappeEntity);
		return this.findOne(retourEntity.getId(), 0);
	}

}
