package fr.grapidee.application.services.entite.grappe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grapidee.application.services.association.grappe.AssociationGrappeEntity;
import fr.grapidee.application.services.association.grappe.AssociationGrappeRepository;
import fr.grapidee.application.services.association.idee.AssociationIdeeEntity;
import fr.grapidee.application.services.association.idee.AssociationIdeeRepository;
import fr.grapidee.application.services.commun.CommunBodyDTO;
import fr.grapidee.application.services.commun.TypeChargement;
import fr.grapidee.application.services.commun.dto.CommunDTO;

@Service
public class GrappeService {

	
	@Autowired
	private GrappeRepository repo;
	
	@Autowired 
	private AssociationGrappeRepository repoAssoGrappe;
	
	@Autowired 
	private AssociationIdeeRepository repoAssoIdee;

	@Autowired
	private MapperGrappe mapper;
	
	public GrappeDTO findOne(Long id, TypeChargement typeChargement) {
		return mapper.mappeOne(repo.findOne(id), typeChargement, true);
	}

	public List<CommunDTO> findAll() {
		return mapper.mappeAll(repo.findAll());
	}

	public GrappeDTO postOne(GrappeBodyDTO grappeDto) {
		
		GrappeEntity parent = null;
		if(null!= grappeDto.getIdParent()){
		 parent =repo.findOne(grappeDto.getIdParent());
		}
		GrappeEntity grappe = mapper.mappeEntity(grappeDto, parent);
		repo.save(grappe);
		
		
		return  mapper.mappeOne(grappe, TypeChargement.BASIQUE, true);
	}

	public GrappeDTO putOne(GrappeBodyDTO grappeDto) {
		GrappeEntity grappeExistante = repo.findOne(grappeDto.getId());
		GrappeEntity parent = null;
		if(null!= grappeDto.getIdParent()){
		 parent = repo.findOne(grappeDto.getIdParent());
		}
		GrappeEntity grappe = mapper.mappeEntity(grappeExistante,grappeDto, parent);
		grappe = repo.save(grappe);
		return  mapper.mappeOne(grappe, TypeChargement.BASIQUE, true);
	}

	public GrappeDTO deleteOne(GrappeBodyDTO grappeDto) {
		GrappeEntity grappeExistante = repo.findOne(grappeDto.getId());
		GrappeEntity parent = repo.findOne(grappeDto.getIdParent());
		
		List<AssociationGrappeEntity> listeAssoGrappe = repoAssoGrappe.findByGrappe(grappeExistante);
		for (AssociationGrappeEntity associationGrappeEntity : listeAssoGrappe) {
			associationGrappeEntity.setGrappe(parent);
			repoAssoGrappe.save(associationGrappeEntity);
		}
		List<AssociationIdeeEntity> listeAssoIdee=	repoAssoIdee.findByGrappe(grappeExistante);
		for (AssociationIdeeEntity associationIdeeEntity : listeAssoIdee) {
			associationIdeeEntity.setGrappe(parent);
			repoAssoIdee.save(associationIdeeEntity);
		}
		repo.delete(grappeExistante);
		return mapper.mappeOne(repo.findOne(grappeDto.getIdParent()),  TypeChargement.BASIQUE, true);
	}



}
