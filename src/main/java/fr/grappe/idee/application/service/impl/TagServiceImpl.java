package fr.grappe.idee.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.grappe.idee.application.model.body.TagBodyDTO;
import fr.grappe.idee.application.model.dto.CommunDTO;
import fr.grappe.idee.application.model.dto.GrappeDTO;
import fr.grappe.idee.application.model.dto.TagDTO;
import fr.grappe.idee.application.model.entity.GrappeEntity;
import fr.grappe.idee.application.model.entity.TagEntity;
import fr.grappe.idee.application.model.mapper.MapperCombox;
import fr.grappe.idee.application.model.mapper.MapperTag;
import fr.grappe.idee.application.model.repository.GrappeRepository;
import fr.grappe.idee.application.model.repository.TagRepository;
import fr.grappe.idee.application.service.GrappeService;
import fr.grappe.idee.application.service.TagService;

@Service
public class TagServiceImpl implements TagService {

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

	@Override
	@Transactional(readOnly = true)
	public List<CommunDTO> findAll() {
		Iterable<TagEntity> liste = repo.findAll();
		return mapperCombo.mapperTag((List<TagEntity>) liste);
	}

	@Override
	@Transactional(readOnly = true)
	public TagDTO findOne(Long id, int niveauInferieur) {

		TagEntity tagEntity = repo.findOne(id);
		List<Long> listeIdee = new ArrayList<>();
		TagDTO retour = mapperTag.mapperUnitaire(tagEntity, 0, niveauInferieur, true, listeIdee);

		return retour;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public TagDTO putOne(TagBodyDTO TagDTO) {
		TagEntity TagEntity = repo.findOne(TagDTO.getId());
		return mapperAndSaveAndMapper(TagEntity, TagDTO);
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public TagDTO postOne(TagBodyDTO TagDTO) {
		TagEntity TagEntity = new TagEntity();
		return mapperAndSaveAndMapper(TagEntity, TagDTO);
	}

	@Override
	public TagDTO injecterTag(String nom, String grappe) throws Exception {

		List<TagEntity> listeTrouve = repo.findByNom(nom);
		if (listeTrouve.isEmpty()) {
			// grappe
			TagBodyDTO tag = new TagBodyDTO();
			tag.setNom(nom);

			// domaine
			if (null != grappe) {
				List<GrappeEntity> liste = grappeRepo.findByNom(grappe);
				GrappeDTO retour = null;
				if (liste.isEmpty()) {
					retour = grappeService.injecterGrappe(grappe, null);
					tag.setIdGrappe(retour.getId());
				} else {
					tag.setIdGrappe(liste.get(0).getId());
				}
			}
			return postOne(tag);
		} else {

			throw new Exception("le tag " + nom + " existe déjà.");

		}

	}

	private TagDTO mapperAndSaveAndMapper(TagEntity TagEntity, TagBodyDTO TagDTO) {
		TagEntity.setNom(TagDTO.getNom());
		if (null != TagDTO.getIdGrappe()) {
			TagEntity.setGrappe(grappeRepo.findOne(TagDTO.getIdGrappe()));
		}
		TagEntity retourEntity = repo.save(TagEntity);
		return this.findOne(retourEntity.getId(), 0);
	}

}
