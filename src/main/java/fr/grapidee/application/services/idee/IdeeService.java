package fr.grapidee.application.services.idee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.grapidee.application.services.tag.TagDTO;
import fr.grapidee.application.services.tag.TagEntity;
import fr.grapidee.application.services.tag.TagRepository;
import fr.grapidee.application.services.tag.TagService;

@Service
public class IdeeService  {

	@Autowired
	private IdeeRepository repo;

	@Autowired
	private TagRepository tagRepo;

	@Autowired
	private TagService tagService;

	@Autowired
	private MapperIdee mapper;

	
	@Transactional(readOnly = true)
	public IdeeDTO findOne(Long id, int levelDemande) {
		IdeeEntity idee = repo.findOne(id);
		List<Long> listeIdee = new ArrayList<>();
		
		return mapper.mapperUnitaire(idee, 0, levelDemande, listeIdee);
	}

	
	@Transactional(propagation = Propagation.MANDATORY)
	public IdeeDTO putOne(IdeeBodyDTO ideeDto) {
		IdeeEntity ideeEntity = repo.findOne(ideeDto.getId());
		ideeEntity.setNom(ideeDto.getNom());
		ideeEntity.setDescription(ideeDto.getContenu());
		if (null != ideeDto.getIdTag()) {
			//ideeEntity.setTag(tagRepo.findOne(ideeDto.getIdTag()));
		}
		return mapperAndSaveAndMapper(ideeEntity, ideeDto);
	}

	
	@Transactional(propagation = Propagation.MANDATORY)
	public IdeeDTO postOne(IdeeBodyDTO ideeDto) {
		IdeeEntity ideeEntity = new IdeeEntity();
		return mapperAndSaveAndMapper(ideeEntity, ideeDto);
	}

	private IdeeDTO mapperAndSaveAndMapper(IdeeEntity ideeEntity, IdeeBodyDTO ideeDto) {
		ideeEntity.setNom(ideeDto.getNom());
		if (null != ideeDto.getContenu()) {
			ideeEntity.setDescription(ideeDto.getContenu());
		}

		if (null != ideeDto.getIdTag()) {
			//ideeEntity.setTag(tagRepo.findOne(ideeDto.getIdTag()));
		}

		IdeeEntity retourEntity = repo.save(ideeEntity);
		return this.findOne(retourEntity.getId(), 3);
	}

	
	public List<IdeeDTO>  findAll() {
		Iterable<IdeeEntity> list= repo.findAll();
		List<IdeeDTO> listeretour= new ArrayList<IdeeDTO>();
		
		List<Long> listeIdee = new ArrayList<Long>();
		for (IdeeEntity idee : list) {
			listeretour.add(mapper.mapperUnitaire(idee, 0, 3, listeIdee ));	
		}
		return listeretour;
	}

}
