package fr.grapidee.application.services.tag;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.grapidee.application.services.commun.CommunDTO;
import fr.grapidee.application.services.commun.MapperCombox;
import fr.grapidee.application.services.grappe.GrappeEntity;
import fr.grapidee.application.services.grappe.GrappeRepository;
import fr.grapidee.application.services.grappe.GrappeService;

@Service
public class TagService {

	@Autowired
	private TagRepository repo;

	@Autowired
	private GrappeRepository grappeRepo;

	@Autowired
	private MapperCombox mapperCombo;

	@Autowired
	private MapperTag mapperTag;

	@Autowired
	private GrappeService grappeService;

	
	@Transactional(readOnly = true)
	public List<CommunDTO> findAll() {
		Iterable<TagEntity> liste = repo.findAll();
		return mapperCombo.mapperTag((List<TagEntity>) liste);
	}

	
	@Transactional(readOnly = true)
	public TagDTO findOne(Long id, int niveauInferieur) {

		TagEntity tagEntity = repo.findOne(id);
		List<Long> listeIdee = new ArrayList<>();
		TagDTO retour = mapperTag.mapperUnitaire(tagEntity, 0, niveauInferieur, true, listeIdee);

		return retour;
	}

	
	@Transactional(propagation = Propagation.MANDATORY)
	public TagDTO putOne(TagBodyDTO TagDTO) throws Exception {
		TagEntity TagEntity = repo.findOne(TagDTO.getId());
		if( null == TagEntity)
		{
			throw new Exception("le tagg "+ TagDTO.getId()+ " existe pas.");
		}
		return mapperAndSaveAndMapper(TagEntity, TagDTO);
	}


	@Transactional(propagation = Propagation.MANDATORY)
	public TagDTO postOne(TagBodyDTO TagDTO) throws Exception {
		
		
		TagEntity TagEntity = new TagEntity();
		
		List<TagEntity> listeTrouve=	repo.findByNom(TagDTO.getNom());
		if(listeTrouve.isEmpty())
		{
		return mapperAndSaveAndMapper(TagEntity, TagDTO);  
		}
		else
		{
			throw new Exception("le domaine "+ TagDTO.getNom()+ " existe déjà.");
		}
	}


	private TagDTO mapperAndSaveAndMapper(TagEntity TagEntity, TagBodyDTO TagDTO) {
		TagEntity.setNom(TagDTO.getNom());
		if (null != TagDTO.getIdGrappe()) {
		//	TagEntity.setGrappe(grappeRepo.findOne(TagDTO.getIdGrappe()));
		}
		TagEntity retourEntity = repo.save(TagEntity);
		return this.findOne(retourEntity.getId(), 0);
	}

}
