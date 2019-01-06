package fr.grapidee.application.services.entite.grappe;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grapidee.application.services.association.grappe.AssociationGrappeEntity;
import fr.grapidee.application.services.commun.dto.CommunDTO;
import fr.grapidee.application.services.entite.idee.IdeeDTO;
import fr.grapidee.application.services.entite.idee.MapperIdee;

@Service
public class MapperGrappe {

	@Autowired
	private MapperIdee mapperIdee;

	public GrappeDTO mappeOne(GrappeEntity entity, Boolean complet) {
		GrappeDTO retour = new GrappeDTO();
		mappeBase(entity, retour);

		if (complet) {

			if (null != entity.getGrappeParent()) {
				retour.setGrappeParent(mappeParent(entity.getGrappeParent()));
			}
			if (null != entity.getListeAssoIdee()) {
				retour.setIdees(mapperIdee.mappeAssoIdees(entity.getListeAssoIdee(), complet));
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
		return retour;
	}

	public List<CommunDTO> mappeAll(Iterable<GrappeEntity> entitys) {
		List<CommunDTO> retour = Arrays.asList();
		entitys.forEach(entity -> retour.add(mappeParent(entity)));
		return retour;
	}

	public List<GrappeDTO> mappeAssoGrappes(
			List<AssociationGrappeEntity> entitys) {
		List<GrappeDTO> retour = Arrays.asList();
		entitys.forEach(entity -> retour.add(mappeAssoGrappe(entity)));
		return retour;
	}

	private GrappeDTO mappeAssoGrappe(AssociationGrappeEntity entity) {
		GrappeDTO retour = new GrappeDTO();
		GrappeEntity grappe = entity.getGrappe();
		mappeBase(grappe, retour);
		retour.setGrappeParent(mappeParent(grappe.getGrappeParent()));
		
		return retour;
	}

}
