package fr.grapidee.application.services.entite.grappe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grapidee.application.services.association.grappe.AssociationGrappeEntity;
import fr.grapidee.application.services.commun.CommunBodyDTO;
import fr.grapidee.application.services.commun.TypeChargement;
import fr.grapidee.application.services.commun.dto.CommunDTO;
import fr.grapidee.application.services.entite.idee.IdeeDTO;
import fr.grapidee.application.services.entite.idee.MapperIdee;

@Service
public class MapperGrappe {

	private static final int NBR_NIVEAU_IDEE = 1;
	
	@Autowired
	private MapperIdee mapperIdee;

	public GrappeDTO mappeOne(GrappeEntity entity, TypeChargement typeChargement, boolean needParent) {
		GrappeDTO retour = new GrappeDTO();
		mappeBase(entity, retour);

		if (TypeChargement.estAuMoins(typeChargement, TypeChargement.BASIQUE)) {
			if( null !=entity.getListeEnfants() &&entity.getListeEnfants().size()>0){
				retour.setGrappeEnfants(mappeAll(entity.getListeEnfants(), typeChargement, false));
			}
		}
		if (needParent &&TypeChargement.estAuMoins(typeChargement, TypeChargement.ARBRE)) {
			if (null != entity.getGrappeParent()) {
				retour.setGrappeParent(mappeParent(entity.getGrappeParent()));
			}
		}
		if (TypeChargement.estAuMoins(typeChargement, TypeChargement.COMPLET)) {
			if (null != entity.getListeAssoIdee()&&entity.getListeAssoIdee().size()>0) {
				retour.setIdees(mapperIdee.mappeAssoIdees(entity.getListeAssoIdee(), typeChargement,NBR_NIVEAU_IDEE));
			}
		}

		return retour;
	}

	private void mappeBase(GrappeEntity entity, GrappeDTO retour) {
		retour.setId(entity.getId());
		retour.setNom(entity.getNom());
		retour.setDescription(entity.getDescription());
		if (null != entity.getType()) {
			retour.setType(entity.getType().getNom());
		}
	}

	private GrappeDTO mappeParent(GrappeEntity grappeParent) {
		GrappeDTO retour = new GrappeDTO();
		mappeBase(grappeParent, retour);
		if( null != grappeParent.getGrappeParent()){
		retour.setGrappeParent(mappeParent(grappeParent.getGrappeParent()));
		}
		return retour;
	}
	public List<GrappeDTO> mappeAll(Iterable<GrappeEntity> entitys, TypeChargement typeChargement, boolean needParent) {
		List<GrappeDTO> retour = new ArrayList<GrappeDTO>();
		for (GrappeEntity entity : entitys) {
			retour.add(mappeOne(entity,typeChargement , needParent));
		}
		return retour;
	}
	
	public List<CommunDTO> mappeAll(Iterable<GrappeEntity> entitys) {
		List<CommunDTO> retour = new ArrayList<CommunDTO>();
		for (GrappeEntity entity : entitys) {
			retour.add(mappeParent(entity));
		}
		return retour;
	}

	public List<GrappeDTO> mappeAssoGrappes(
			List<AssociationGrappeEntity> entitys) {
		List<GrappeDTO> retour = new ArrayList<GrappeDTO>();
		entitys.forEach(entity -> retour.add(mappeAssoGrappe(entity)));
		return retour;
	}

	private GrappeDTO mappeAssoGrappe(AssociationGrappeEntity entity) {
		GrappeDTO retour = new GrappeDTO();
		GrappeEntity grappe = entity.getGrappe();
		mappeBase(grappe, retour);
		if( null != grappe.getGrappeParent()){
		retour.setGrappeParent(mappeParent(grappe.getGrappeParent()));
		}
		
		return retour;
	}

	public GrappeEntity mappeEntity(CommunBodyDTO grappeDto, GrappeEntity parent) {
		GrappeEntity entity = new GrappeEntity();
		entity.setNom(grappeDto.getNom());
		entity.setDescription(grappeDto.getDescription());
		entity.setGrappeParent(parent);
		return entity;
	}

	public GrappeEntity mappeEntity(GrappeEntity grappeExistante,
			CommunBodyDTO grappeDto, GrappeEntity parent) {
		grappeExistante.setNom(grappeDto.getNom());
		grappeExistante.setDescription(grappeDto.getDescription());
		grappeExistante.setGrappeParent(parent);
		return grappeExistante;
	}

}
