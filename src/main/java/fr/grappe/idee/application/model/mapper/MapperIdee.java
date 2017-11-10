package fr.grappe.idee.application.model.mapper;

import java.util.ArrayList;import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import fr.grappe.idee.application.model.dto.IdeeDTO;
import fr.grappe.idee.application.model.entity.AssociationEntity;
import fr.grappe.idee.application.model.entity.IdeeEntity;

@Service
public class MapperIdee {

	public IdeeDTO mapperUnitaire(final IdeeEntity idee, final int level, final int levelDemande) {

		int levelActuel = level+1;
		if( levelDemande == 0)
		{
			return null;
		} else if (levelActuel == levelDemande || levelDemande == 1) {
			return mapperBadge(idee, levelActuel);
		} else if (levelActuel < levelDemande) {
			return mapperUnitaireTotal(idee, levelActuel, levelDemande);
		} else {
			return null;
		}


	}

	/***
	 * mapper seulement le nombre d'élement d'une grappe pour l'utiliser sous
	 * forme de badge
	 * 
	 * @param idee
	 *            entrée
	 */
	private IdeeDTO mapperBadge(IdeeEntity idee, int level) {
		IdeeDTO ideeDto = new IdeeDTO();
		mapperCommun(idee, ideeDto, level);

		ideeDto.setContenu(mapperBadge(idee.getListeAssoIdee()));
		ideeDto.setListeEsclave(new ArrayList<>());

		return ideeDto;

	}

	private String mapperBadge(List<AssociationEntity> listeIdee) {
		StringBuilder contenu = new StringBuilder();
		Map<String, Integer> mapBadge = new HashMap<>();

		// on mappe le nombre d'élement d'une grappe
		for (AssociationEntity associationEntity : listeIdee) {

			String cle = associationEntity.getGrappe().getNom();
			if (mapBadge.containsKey(cle)) {
				Integer newValeur = mapBadge.get(cle);
				newValeur += 1;
				mapBadge.put(cle, newValeur);

			} else {
				mapBadge.put(cle, 1);

			}

		}

		// on crée un contenu qui liste les grappes et le nombre d'élemet dans
		// cette grappe
		Set<String> listeCle = mapBadge.keySet();
		for (String cle : listeCle) {
			contenu.append(cle);
			contenu.append(" : ");
			contenu.append(String.valueOf(mapBadge.get(cle)));
			contenu.append("  ");

		}
		return contenu.toString();
	}

	/***
	 * mapper les champs commun
	 * 
	 * @param idee
	 * @param ideeDto
	 * @param level
	 */
	private void mapperCommun(IdeeEntity idee, IdeeDTO ideeDto, int level) {
		ideeDto.setId(idee.getId());
		ideeDto.setNom(idee.getNom());
		ideeDto.setLevel(level);
	}

	/***
	 * mapper tout le dto
	 * 
	 * @param idee
	 *            idée entity
	 * @param level
	 *            le niveau de représentation actuel
	 * @param levelDemande
	 *            le niveau de representation demande
	 * @return
	 */
	private IdeeDTO mapperUnitaireTotal(IdeeEntity idee, int level, int levelDemande) {
		IdeeDTO ideeDto = new IdeeDTO();
		mapperCommun(idee, ideeDto, level);
		ideeDto.setProjet(idee.getProjet());
		ideeDto.setContenu(idee.getContenu());
		ideeDto.setListeEsclave(mapperEsclave(idee, level, levelDemande));
		return ideeDto;
	}

	private List<IdeeDTO> mapperEsclave(IdeeEntity idee, int level, int levelDemande) {
		List<IdeeDTO> listeRetour = new ArrayList<>();
		if (null != idee.getListeAssoIdee()) {
			for (AssociationEntity ideeEsclave : idee.getListeAssoIdee()) {
				listeRetour.add(mapperUnitaire(ideeEsclave.getIdeeEsclave(), level, levelDemande));

			}
		}
		return listeRetour;
	}
}
