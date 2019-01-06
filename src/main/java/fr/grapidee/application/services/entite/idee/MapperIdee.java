package fr.grapidee.application.services.entite.idee;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grapidee.application.services.association.grappe.AssociationGrappeEntity;
import fr.grapidee.application.services.association.idee.AssociationIdeeEntity;
import fr.grapidee.application.services.association.idee.IdeeEsclaveDTO;
import fr.grapidee.application.services.entite.grappe.MapperGrappe;

@Service
public class MapperIdee {

	@Autowired
	private MapperGrappe mapperGrappe;

	public IdeeDTO mappeOne(IdeeEntity entity, boolean complet) {
		IdeeDTO retour = new IdeeDTO();
		mappeBase(retour, entity);

		if (complet) {
			if (null != entity.getListeAssoGrappe()) {
				retour.setGrappes(mapperGrappe.mappeAssoGrappes(entity
						.getListeAssoGrappe()));
			}
			if (null != entity.getListeAssoIdee()) {
				retour.setIdees(mappeEsclaves(entity.getListeAssoIdee(),
						complet));
			}
		}

		return retour;
	}

	private List<IdeeEsclaveDTO> mappeEsclaves(
			List<AssociationIdeeEntity> entitys, Boolean complet) {

		List<IdeeEsclaveDTO> retour = Arrays.asList();
		entitys.forEach(entity -> retour.add(mappeEsclave(entity, complet)));
		return retour;
	}

	private IdeeEsclaveDTO mappeEsclave(AssociationIdeeEntity entity,
			Boolean complet) {
		IdeeEsclaveDTO retour = new IdeeEsclaveDTO();
		retour.setLiaison(entity.getLiaison());
		mappeOne(entity.getIdeeEsclave(), complet);

		return retour;
	}

	public List<IdeeDTO> mappeAll(Iterable<IdeeEntity> entitys, boolean complet) {
		List<IdeeDTO> retour = Arrays.asList();
		entitys.forEach(entity -> retour.add(mappeOne(entity, complet)));
		return retour;
	}

	private void mappeBase(IdeeDTO retour, IdeeEntity entity) {

		retour.setId(entity.getId());
		retour.setNom(entity.getNom());
		retour.setDescription(entity.getDescription());

	}

	public List<IdeeDTO> mappeAssoIdees(
			List<AssociationGrappeEntity> entitys, Boolean complet) {
		List<IdeeDTO> retour = Arrays.asList();
		entitys.forEach(entity -> retour.add(mappeAssoIdee(entity, complet)));
		return retour;
	}

	private IdeeDTO mappeAssoIdee(AssociationGrappeEntity entity,
			Boolean complet) {
		return mappeOne(entity.getIdee(), complet);
	}
}
