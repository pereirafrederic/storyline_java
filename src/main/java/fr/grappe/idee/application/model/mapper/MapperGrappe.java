package fr.grappe.idee.application.model.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grappe.idee.application.model.dto.BadgeDto;
import fr.grappe.idee.application.model.dto.GrappeDTO;
import fr.grappe.idee.application.model.entity.AssociationEntity;
import fr.grappe.idee.application.model.entity.GrappeEntity;
import utils.comparator.ComparatorSort;

@Service
public class MapperGrappe {

	@Autowired
	private MapperIdee mapperIdee;

	public GrappeDTO mapperUnitaire(GrappeEntity grappe, int niveauInferieur, int niveaudemande, List<Long> listeIdee) {
		GrappeDTO retour = new GrappeDTO();
		retour.setNom(grappe.getNom());
		retour.setId(grappe.getId());
		niveauInferieur++;
		if (niveauInferieur < niveaudemande) {
			if (null != grappe.getListeIdee()) {
				List<AssociationEntity> listeGrappeSort = ComparatorSort.getIdeeSortByGrappe(grappe.getListeIdee());

				for (AssociationEntity asso : listeGrappeSort) {
					retour.getListeIdee()
							.add(mapperIdee.mapperUnitaire(asso.getIdeeEsclave(), niveauInferieur, niveaudemande, listeIdee));

				}
			}
		} else

		{
			retour.setListeBadge(this.mapperBadge(grappe.getListeIdee()));
		}
		return retour;
	}

	public List<BadgeDto> mapperBadge(List<AssociationEntity> listeIdee) {
		Map<String, Integer> mapBadge = new HashMap<>();
		if (null != listeIdee) {
			// on mappe le nombre d'élement d'une grappe
			List<AssociationEntity> listeGrappeSort = ComparatorSort.getIdeeSortByGrappe(listeIdee);

			for (AssociationEntity associationEntity : listeGrappeSort) {

				String cle = associationEntity.getIdeeEsclave().getNom();
				if (mapBadge.containsKey(cle)) {
					Integer newValeur = mapBadge.get(cle);
					newValeur += 1;
					mapBadge.put(cle, newValeur);

				} else {
					mapBadge.put(cle, 1);

				}

			}
		}

		List<BadgeDto> listeBadge = new ArrayList<>();
		Long id = 0L;
		Set<String> listeCle = mapBadge.keySet();
		for (String cle : listeCle) {
			id++;
			BadgeDto badge = new BadgeDto();
			badge.setId(id);
			badge.setNom(cle);
			badge.setNombre(mapBadge.get(cle));
			listeBadge.add(badge);
		}
		return listeBadge;
	}

}
