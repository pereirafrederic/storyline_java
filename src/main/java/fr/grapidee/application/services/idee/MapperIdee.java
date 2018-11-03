package fr.grapidee.application.services.idee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grapidee.application.services.associationIdee.AssociationEntity;
import fr.grapidee.application.services.associationIdee.IdeeDomaineDTO;
import fr.grapidee.application.services.associationIdee.IdeeGrappeDTO;
import fr.grapidee.application.services.commun.BadgeDto;
import fr.grapidee.application.services.domaine.DomaineEntity;
import fr.grapidee.application.services.grappe.GrappeEntity;
import fr.grapidee.application.services.projet.ProjetDTO;
import fr.grapidee.application.services.projet.ProjetEntity;
import fr.grapidee.application.services.tag.MapperTag;

@Service
public class MapperIdee {

	@Autowired
	private MapperTag mapperTag;

	public IdeeDTO mapperUnitaire(final IdeeEntity idee, final int level, final int levelDemande, List<Long> listeIdee) {

		int levelActuel = level + 1;
		if (levelDemande == 0) {
			return null;
		} else if (listeIdee.contains(idee.getId()) || levelActuel == levelDemande || levelDemande == 1) {
			return mapperBadge(idee, levelActuel);
		} else if (levelActuel < levelDemande) {
			return mapperUnitaireTotal(idee, levelActuel, levelDemande, listeIdee);
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
	public IdeeDTO mapperBadge(IdeeEntity idee, int level) {
		IdeeDTO ideeDto = new IdeeDTO();
		mapperCommun(idee, ideeDto, level);

		ideeDto.setContenu(idee.getDescription());
		ideeDto.setListeEsclave(new ArrayList<>());
		ideeDto.setListeBadge(mapperBadge(idee.getListeAssoIdee()));

		return ideeDto;

	}

	public List<BadgeDto> mapperBadge(List<AssociationEntity> listeIdee) {
		Map<String, Integer> mapBadge = new HashMap<>();
		if (null != listeIdee) {
			// on mappe le nombre d'élement d'une grappe
			for (AssociationEntity associationEntity : listeIdee) {

				if(null !=associationEntity.getGrappe())
				{
				String cle = associationEntity.getGrappe().getNom();
				if (mapBadge.containsKey(cle)) {
					Integer newValeur = mapBadge.get(cle);
					newValeur += 1;
					mapBadge.put(cle, newValeur);

				} else {
					mapBadge.put(cle, 1);

				}
				}
				else
				{
					mapBadge.put(associationEntity.getIdeeEsclave().getNom(), 1);
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
	 * @param listeIdee 
	 * @return
	 */
	private IdeeDTO mapperUnitaireTotal(IdeeEntity idee, int level, int levelDemande, List<Long> listeIdee) {
		IdeeDTO ideeDto = new IdeeDTO();
		mapperCommun(idee, ideeDto, level);
		//ideeDto.setProjet(idee.getProjet()());
		ideeDto.setContenu(idee.getDescription());
	/*	if (null != idee.getTag()) {
			ideeDto.setTag(mapperTag.mapperUnitaire(idee.getTag(), 0, 2, false, listeIdee));
		}*/
		mapperIdeeEsclaveParRegroupement(ideeDto, idee, level, levelDemande, listeIdee);

		listeIdee.add(idee.getId());
		return ideeDto;
	}

	private void mapperIdeeEsclaveParRegroupement(IdeeDTO ideeDto, IdeeEntity idee, int level, int levelDemande, List<Long> listeIdee) {


		ideeDto.setListeDomaine(new ArrayList<>());
		ideeDto.setListeGrappe(new ArrayList<>());
		ideeDto.setListeEsclave(new ArrayList<>());
		
		Map<String, IdeeDomaineDTO> mapDomaine = new HashMap<>();
		Map<String, IdeeGrappeDTO> mapGrappe = new HashMap<>();
		List<IdeeDTO> listeEsclave = new ArrayList<>();
		if (null != idee.getListeAssoIdee()) {

			for (AssociationEntity assoIdeeEsclave : idee.getListeAssoIdee()) {

				if (null != assoIdeeEsclave.getGrappe() && null != assoIdeeEsclave.getGrappe().getDomaine()) {

					String key = assoIdeeEsclave.getGrappe().getDomaine().getNom();
					if (mapDomaine.containsKey(key)) {

						// maj de la liste des idées liées au domaine
						IdeeDomaineDTO ideeDomaine = mapDomaine.get(key);
						ideeDomaine.setListeIdee(mapperIdeeEsclaveParRegroupementGrappe(ideeDomaine, assoIdeeEsclave,
								level, levelDemande, listeIdee));
						mapDomaine.remove(key);
						mapDomaine.put(key, ideeDomaine);
					} else {
						// création d'un domaine et de sa première idée
						IdeeDomaineDTO ideeDomaine = new IdeeDomaineDTO();
						DomaineEntity dom = assoIdeeEsclave.getGrappe().getDomaine();
						ideeDomaine.setId(dom.getId());
						ideeDomaine.setNom(dom.getNom());
						ideeDomaine.setListeIdee(mapperIdeeEsclaveParRegroupementGrappe(ideeDomaine, assoIdeeEsclave,
								level, levelDemande, listeIdee));
						mapDomaine.put(key, ideeDomaine);
					}

				} else if (null != assoIdeeEsclave.getGrappe()) {
					String key = assoIdeeEsclave.getGrappe().getNom();
					if (mapGrappe.containsKey(key)) {
						IdeeGrappeDTO ideeGrappe = mapGrappe.get(key);
						ideeGrappe.getListeIdee()
								.add(mapperUnitaire(assoIdeeEsclave.getIdeeEsclave(), level, levelDemande, listeIdee));
						mapGrappe.remove(key);
						mapGrappe.put(key, ideeGrappe);
					} else {
						IdeeGrappeDTO ideeGrappe = new IdeeGrappeDTO();
						GrappeEntity grap = assoIdeeEsclave.getGrappe();
						ideeGrappe.setId(grap.getId());
						ideeGrappe.setNom(grap.getNom());
						ideeGrappe.setListeIdee(new ArrayList<>());
						ideeGrappe.getListeIdee()
								.add(mapperUnitaire(assoIdeeEsclave.getIdeeEsclave(), level, levelDemande, listeIdee));
						mapGrappe.put(key, ideeGrappe);
					}

				} else {
					listeEsclave.add(mapperUnitaire(assoIdeeEsclave.getIdeeEsclave(), level, levelDemande, listeIdee));
				}

			}
			
			if (!mapDomaine.isEmpty()) {
				for (IdeeDomaineDTO domaineElement : mapDomaine.values()) {
					if (domaineElement.getListeIdee().size() == 1) {
						IdeeGrappeDTO grappe = domaineElement.getListeIdee().get(0);
						grappe.setNom(domaineElement.getNom() + " - " + grappe.getNom());
						mapGrappe.put(grappe.getNom(), grappe);
					} else {
						ideeDto.getListeDomaine().add(domaineElement);
					}
				}
			}
			if (!mapGrappe.isEmpty()) {
				for (IdeeGrappeDTO grappeElement : mapGrappe.values()) {
					if (grappeElement.getListeIdee().size() == 1) {
						IdeeDTO ideeElement = grappeElement.getListeIdee().get(0);
						ideeElement.setNom(grappeElement.getNom() + " - " + ideeElement.getNom());
						listeEsclave.add(ideeElement);
					} else {
						ideeDto.getListeGrappe().add(grappeElement);
					}

				}
			}
			ideeDto.setListeEsclave(listeEsclave);

		}

	}

	private List<IdeeGrappeDTO> mapperIdeeEsclaveParRegroupementGrappe(IdeeDomaineDTO ideeDomaine,
			AssociationEntity ideeEsclaveCourante, int level, int levelDemande, List<Long> listeIdee) {
		List<IdeeGrappeDTO> listeRetour = new ArrayList<>();
		List<IdeeGrappeDTO> listeEntree = ideeDomaine.getListeIdee();
		Map<String, IdeeGrappeDTO> listeGrappe = new HashMap<>();
		if (null != listeEntree) {
			for (IdeeGrappeDTO ideeGrappeDTO : listeEntree) {
				listeGrappe.put(ideeGrappeDTO.getNom(), ideeGrappeDTO);
			}
		}
		String key = ideeEsclaveCourante.getGrappe().getNom();
		if (listeGrappe.containsKey(key)) {
			IdeeGrappeDTO ideeGrappe = listeGrappe.get(key);
			ideeGrappe.getListeIdee().add(mapperUnitaire(ideeEsclaveCourante.getIdeeEsclave(), level, levelDemande, listeIdee));
			listeGrappe.remove(key);
			listeGrappe.put(key, ideeGrappe);

		} else {
			IdeeGrappeDTO ideeGrappe = new IdeeGrappeDTO();
			GrappeEntity grap = ideeEsclaveCourante.getGrappe();
			ideeGrappe.setId(grap.getId());
			ideeGrappe.setNom(grap.getNom());
			ideeGrappe.setListeIdee(new ArrayList<>());
			ideeGrappe.getListeIdee().add(mapperUnitaire(ideeEsclaveCourante.getIdeeEsclave(), level, levelDemande, listeIdee));
			listeGrappe.put(key, ideeGrappe);

		}

		for (IdeeGrappeDTO ideeGrappeDTO : listeGrappe.values()) {
			listeRetour.add(ideeGrappeDTO);

		}

		return listeRetour;
	}

	public List<ProjetDTO> mapperProjet(List<ProjetEntity> liste) {
		List<ProjetDTO> dtos = new ArrayList<ProjetDTO>();
		liste.stream().forEach( projetEntity -> {
			dtos.add(mapperProjet( projetEntity));
		});
		
		return dtos;
	}

	private ProjetDTO mapperProjet( ProjetEntity projetEntity) {
		ProjetDTO dto = new ProjetDTO();
		dto.setId(projetEntity.getId());
		dto.setNom(projetEntity.getNom());
		projetEntity.getProjets().stream().forEach( projet ->{
			ProjetDTO projetdto = new ProjetDTO();
			projetdto.setId(projet.getId());
			projetdto.setNom(projet.getNom());
			dto.getProjets().add(projetdto);
		});
		
		return dto;
	}
}
