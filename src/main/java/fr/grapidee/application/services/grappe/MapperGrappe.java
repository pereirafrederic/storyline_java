package fr.grapidee.application.services.grappe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grapidee.application.services.associationIdee.AssociationEntity;
import fr.grapidee.application.services.commun.BadgeDto;
import fr.grapidee.application.services.idee.IdeeEntity;
import fr.grapidee.application.services.idee.MapperIdee;
import fr.grapidee.application.utilitaire.comparator.ComparatorSort;

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
				for (IdeeEntity idee : grappe.getListeIdee()) {
					retour.getListeIdee()
							.add(mapperIdee.mapperUnitaire(idee, niveauInferieur, niveaudemande, listeIdee));

				}
			}
		} else

		{
			//retour.setListeBadge(this.mapperBadge(grappe.getListeIdee()));
		}
		return retour;
	}

}
