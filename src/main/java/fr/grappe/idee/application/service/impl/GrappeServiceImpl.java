package fr.grappe.idee.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.grappe.idee.application.model.body.GrappeBodyDTO;
import fr.grappe.idee.application.model.dto.CommunDTO;
import fr.grappe.idee.application.model.dto.DomaineDTO;
import fr.grappe.idee.application.model.dto.GrappeDTO;
import fr.grappe.idee.application.model.entity.DomaineEntity;
import fr.grappe.idee.application.model.entity.GrappeEntity;
import fr.grappe.idee.application.model.mapper.MapperCombox;
import fr.grappe.idee.application.model.mapper.MapperGrappe;
import fr.grappe.idee.application.model.repository.DomaineRepository;
import fr.grappe.idee.application.model.repository.GrappeRepository;
import fr.grappe.idee.application.service.DomaineService;
import fr.grappe.idee.application.service.GrappeService;

@Service
public class GrappeServiceImpl implements GrappeService {

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

	@Override
	@Transactional(readOnly = true)
	public List<CommunDTO> findAll() {
		Iterable<GrappeEntity> listeGrappe = repo.findAll();
		return mapperCombo.mapperGrappe((List<GrappeEntity>) listeGrappe);
	}

	@Override
	@Transactional(readOnly = true)
	public GrappeDTO findOne(Long id, int niveauInferieur) {

		GrappeEntity grappe = repo.findOne(id);
		List<Long> listeIdee = new ArrayList<>();
		GrappeDTO retour = mapperGrappe.mapperUnitaire(grappe, 0, niveauInferieur, listeIdee);

		return retour;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public GrappeDTO putOne(GrappeBodyDTO grappeDto) {
		GrappeEntity grappeEntity = repo.findOne(grappeDto.getId());
		return mapperAndSaveAndMapper(grappeEntity, grappeDto);
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public GrappeDTO postOne(GrappeBodyDTO grappeDto) {
		GrappeEntity grappeEntity = new GrappeEntity();
		return mapperAndSaveAndMapper(grappeEntity, grappeDto);
	}

	@Override
	public GrappeDTO injecterGrappe(String nom, String domaine) throws Exception {

		List<GrappeEntity> listeTrouve = repo.findByNom(nom);
		if (listeTrouve.isEmpty()) {
			// grappe
			GrappeBodyDTO grappe = new GrappeBodyDTO();
			grappe.setNom(nom);

			// domaine
			if (null != domaine) {
				List<DomaineEntity> liste = domaineRepo.findByNom(domaine);
				DomaineDTO retourDomaine = null;
				if (liste.isEmpty()) {
					retourDomaine = domaineService.injecterDomaine(domaine);
					grappe.setIdDomaine(retourDomaine.getId());
				} else {
					grappe.setIdDomaine(liste.get(0).getId());
				}
			}
			return postOne(grappe);
		} else {

			throw new Exception("la grappe " + nom + " existe déjà.");

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
