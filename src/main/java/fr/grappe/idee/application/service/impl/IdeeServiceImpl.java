package fr.grappe.idee.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.grappe.idee.application.model.body.IdeeBodyDTO;
import fr.grappe.idee.application.model.dto.DomaineDTO;
import fr.grappe.idee.application.model.dto.IdeeDTO;
import fr.grappe.idee.application.model.dto.TagDTO;
import fr.grappe.idee.application.model.entity.DomaineEntity;
import fr.grappe.idee.application.model.entity.IdeeEntity;
import fr.grappe.idee.application.model.entity.TagEntity;
import fr.grappe.idee.application.model.mapper.MapperIdee;
import fr.grappe.idee.application.model.repository.IdeeRepository;
import fr.grappe.idee.application.model.repository.TagRepository;
import fr.grappe.idee.application.service.IdeeService;
import fr.grappe.idee.application.service.TagService;

@Service
public class IdeeServiceImpl implements IdeeService {

	@Autowired
	private IdeeRepository repo;

	@Autowired
	private TagRepository tagRepo;

	@Autowired
	private TagService tagService;

	@Autowired
	private MapperIdee mapper;

	@Override
	@Transactional(readOnly = true)
	public IdeeDTO findOne(Long id, int levelDemande) {
		IdeeEntity idee = repo.findOne(id);
		List<Long> listeIdee = new ArrayList<>();
		
		return mapper.mapperUnitaire(idee, 0, levelDemande, listeIdee);
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public IdeeDTO putOne(IdeeBodyDTO ideeDto) {
		IdeeEntity ideeEntity = repo.findOne(ideeDto.getId());
		ideeEntity.setNom(ideeDto.getNom());
		ideeEntity.setContenu(ideeDto.getContenu());
		if (null != ideeDto.getIdTag()) {
			ideeEntity.setTag(tagRepo.findOne(ideeDto.getIdTag()));
		}
		return mapperAndSaveAndMapper(ideeEntity, ideeDto);
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public IdeeDTO postOne(IdeeBodyDTO ideeDto) {
		IdeeEntity ideeEntity = new IdeeEntity();
		return mapperAndSaveAndMapper(ideeEntity, ideeDto);
	}

	private IdeeDTO mapperAndSaveAndMapper(IdeeEntity ideeEntity, IdeeBodyDTO ideeDto) {
		ideeEntity.setNom(ideeDto.getNom());
		if (null != ideeDto.getContenu()) {
			ideeEntity.setContenu(ideeDto.getContenu());
		}
		ideeEntity.setProjet(false);

		if (null != ideeDto.getIdTag()) {
			ideeEntity.setTag(tagRepo.findOne(ideeDto.getIdTag()));
		}

		IdeeEntity retourEntity = repo.save(ideeEntity);
		return this.findOne(retourEntity.getId(), 0);
	}

	@Override
	public IdeeDTO injecterIdee(String nom, String contenu, String tag) throws Exception {

		List<IdeeEntity> listeTrouve = repo.findByNom(nom);
		IdeeBodyDTO dto = new IdeeBodyDTO();
		dto.setNom(nom);
		if (null != contenu) {
			dto.setContenu(contenu);
		}
		remplirTag(tag, dto);
		if (listeTrouve.isEmpty()) {
			return postOne(dto);
		} else {
			dto.setId(listeTrouve.get(0).getId());
			if (null == contenu) {
				dto.setContenu(listeTrouve.get(0).getContenu());
			}
			return putOne(dto);
		}
	}

	private void remplirTag(String tag, IdeeBodyDTO dto) throws Exception {
		// tag
		if (null != tag) {
			List<TagEntity> liste = tagRepo.findByNom(tag);
			TagDTO retourTag = null;
			if (liste.isEmpty()) {
				retourTag = tagService.injecterTag(tag, null);
				dto.setIdTag(retourTag.getId());
			} else {
				dto.setIdTag(liste.get(0).getId());
			}
		}
	}

}
