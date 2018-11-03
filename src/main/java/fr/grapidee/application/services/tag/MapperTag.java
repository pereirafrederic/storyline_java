package fr.grapidee.application.services.tag;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grapidee.application.services.commun.BadgeDto;
import fr.grapidee.application.services.idee.IdeeEntity;
import fr.grapidee.application.services.idee.MapperIdee;

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
			/*	if (null != tagEntity.getListeIdee()) {
					for (IdeeEntity idee : tagEntity.getListeIdee()) {
						retour.getListeIdee().add(mapperIdee.mapperUnitaire(idee, niveauInferieur, niveaudemande, listeIdee));

					}
				}*/
			} else

			{
				//retour.setListeBadge(this.mapperBadge(tagEntity.getListeIdee()));
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
