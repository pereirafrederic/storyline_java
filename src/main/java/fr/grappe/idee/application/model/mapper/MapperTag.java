package fr.grappe.idee.application.model.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grappe.idee.application.model.dto.BadgeDto;
import fr.grappe.idee.application.model.dto.TagDTO;
import fr.grappe.idee.application.model.dto.TagDTO;
import fr.grappe.idee.application.model.entity.AssociationEntity;
import fr.grappe.idee.application.model.entity.IdeeEntity;
import fr.grappe.idee.application.model.entity.TagEntity;
import utils.comparator.ComparatorSort;

@Service
public class MapperTag {

	@Autowired
	private MapperIdee mapperIdee;

	public TagDTO mapperUnitaire(TagEntity tagEntity, int niveauInferieur, int niveaudemande, Boolean avecIdee, List<Long> listeIdee) {
		TagDTO retour = new TagDTO();
		retour.setNom(tagEntity.getNom());
		retour.setId(tagEntity.getId());
		if (avecIdee) {
			niveauInferieur++;
			if (niveauInferieur < niveaudemande) {
				if (null != tagEntity.getListeIdee()) {
					for (IdeeEntity idee : tagEntity.getListeIdee()) {
						retour.getListeIdee().add(mapperIdee.mapperUnitaire(idee, niveauInferieur, niveaudemande, listeIdee));

					}
				}
			} else

			{
				retour.setListeBadge(this.mapperBadge(tagEntity.getListeIdee()));
			}
		}
		return retour;

	}

	public List<BadgeDto> mapperBadge(List<IdeeEntity> listeIdee) {

		List<BadgeDto> listeBadge = new ArrayList<>();
		if (null != listeIdee) {
			for (IdeeEntity idee : listeIdee) {
				BadgeDto badge = new BadgeDto();
				badge.setId(idee.getId());
				badge.setNom(idee.getNom());
				badge.setNombre(1);
				listeBadge.add(badge);
			}
		}
		return listeBadge;
	}

}
