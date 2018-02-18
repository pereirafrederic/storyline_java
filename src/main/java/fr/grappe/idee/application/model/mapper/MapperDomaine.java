package fr.grappe.idee.application.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grappe.idee.application.model.dto.BadgeDto;
import fr.grappe.idee.application.model.dto.DomaineDTO;
import fr.grappe.idee.application.model.entity.DomaineEntity;
import fr.grappe.idee.application.model.entity.GrappeEntity;
import utils.comparator.ComparatorSort;

@Service
public class MapperDomaine {

	@Autowired
	private MapperGrappe mapperGrappe;

	public DomaineDTO mapperUnitaire(DomaineEntity domaineEntity, int niveauInferieur, int niveauDemande, List<Long> listeIdee) {
		DomaineDTO retour = new DomaineDTO();
		retour.setNom(domaineEntity.getNom());
		retour.setId(domaineEntity.getId());
		niveauInferieur++;
		if (niveauInferieur < niveauDemande) {

			if (null != domaineEntity.getListeGrappe()) {
				List<GrappeEntity> listeGrappeSort = ComparatorSort.getGrappeSortByNom(domaineEntity.getListeGrappe());

				for (GrappeEntity grappe : listeGrappeSort) {
					retour.getListeGrappe().add(mapperGrappe.mapperUnitaire(grappe, niveauInferieur, niveauDemande, listeIdee));

				}
			}
		} else {
			retour.setListeBadge(this.mapperBadge(domaineEntity.getListeGrappe()));
		}
		return retour;
	}

	public List<BadgeDto> mapperBadge(List<GrappeEntity> listeGrappe) {
		Long id = 0L;
		List<BadgeDto> listeBadge = new ArrayList<>();
		if (null != listeGrappe) {
			List<GrappeEntity> listeGrappeSort = ComparatorSort.getGrappeSortByNom(listeGrappe);

			for (GrappeEntity grappe : listeGrappeSort) {
				id++;
				BadgeDto badge = new BadgeDto();
				badge.setId(id);
				if (null != grappe.getDomaine()) {
					badge.setIdDomaine(grappe.getDomaine().getId());
				}
				badge.setNom(grappe.getNom());
				badge.setNombre(grappe.getListeIdee().size());
				listeBadge.add(badge);
			}
		}
		return listeBadge;
	}
}
