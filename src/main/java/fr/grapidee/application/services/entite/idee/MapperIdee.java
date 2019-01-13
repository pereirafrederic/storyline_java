package fr.grapidee.application.services.entite.idee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grapidee.application.services.association.grappe.AssociationGrappeEntity;
import fr.grapidee.application.services.association.idee.AssociationIdeeEntity;
import fr.grapidee.application.services.association.idee.IdeeEsclaveDTO;
import fr.grapidee.application.services.commun.CommunBodyDTO;
import fr.grapidee.application.services.commun.TypeChargement;
import fr.grapidee.application.services.entite.grappe.GrappeDTO;
import fr.grapidee.application.services.entite.grappe.GrappeEntity;
import fr.grapidee.application.services.entite.grappe.MapperGrappe;

@Service
public class MapperIdee {

	@Autowired
	private MapperGrappe mapperGrappe;

	public IdeeDTO mappeOne(IdeeEntity entity, TypeChargement typeChargement,
			int niveau) {
		System.out.println("mappe one - " + entity.getId());

		IdeeDTO retour = new IdeeDTO();
		mappeBase(retour, entity);

		if (niveau > 1) {
			if (TypeChargement.estAuMoins(typeChargement, TypeChargement.ARBRE)) {
				if (null != entity.getListeAssoGrappe()
						&& entity.getListeAssoGrappe().size() > 0) {
					retour.setGrappes(mapperGrappe.mappeAssoGrappes(entity
							.getListeAssoGrappe()));
				}
			}
			if (TypeChargement.estAuMoins(typeChargement,
					TypeChargement.COMPLET)) {

				if (null != entity.getListeAssoIdee()
						&& entity.getListeAssoIdee().size() > 0) {
					retour.setIdees(mappeEsclaves(entity.getListeAssoIdee(),
							typeChargement, niveau - 1));
				}
			}

		}
		return retour;
	}

	private OganisationIdeeDTO mappeEsclaves(
			List<AssociationIdeeEntity> entitys, TypeChargement typeChargement,
			int niveau) {

		OganisationIdeeDTO organisation = new OganisationIdeeDTO();
		for (AssociationIdeeEntity entity : entitys) {
			System.out.println("mappe mappeEsclaves - " + entity.getId());
			IdeeEsclaveDTO idee = mappeEsclave(entity, typeChargement, niveau);

			if (null == entity.getGrappe()) {
				organisation.getIdees().add(idee);
			} else {

				List<GrappeEntity> listeOrdonneMap = getOrdonneArbre(entity
						.getGrappe());
				Collections.reverse(listeOrdonneMap);

				boolean stop = false;
				int i = 0;

				OganisationIdeeDTO organisationCourante = organisation;
				while (stop) {
					GrappeEntity grappeCourante = listeOrdonneMap.get(i);
					System.out.println("mappe mappeEsclaves - "
							+ entity.getId() + "retrouver grappe "
							+ entity.getGrappe().getId() + " sur organisation "
							+ organisation.getNom() + "et les orgas filles "
							+ organisation.getMapIdees());
					int codeRetour = retrouverOuCreerOrganisation(
							organisationCourante, entity.getGrappe(),
							grappeCourante, idee);

					switch (codeRetour) {
					case 1:
						stop = true; // car on ajouté l'idée au bonne endroit
						break;
					case 2:

						// ici on a trouve la grappe, alors on continue à explorer 
						//( avec les orgas filles et la grappe suivante )
						
						OganisationIdeeDTO orga = organisationCourante
								.getMapIdees().get(entity.getGrappe().getId());
						organisationCourante = orga;
						i++;
						break;
					case 3:
						grappeCourante = null;
						OganisationIdeeDTO newOrga = mapperOrganisation(entity,
								 idee);
						organisation.getMapIdees()
								.put(newOrga.getId(), newOrga);
						stop = true; // car on a rajoute tout la grappe
						break;
					default:
						break;
					}

				}
			}

		}
		return organisation;
	}

	private OganisationIdeeDTO mapperOrganisation( AssociationIdeeEntity entity, IdeeEsclaveDTO idee) {
		OganisationIdeeDTO orgaParent=mappeOrganisation(entity.getGrappe(),null, idee);
		return orgaParent;
	}

	private OganisationIdeeDTO mappeOrganisation(GrappeEntity grappe, OganisationIdeeDTO orgaPetiteFille, IdeeEsclaveDTO idee) {
		
		OganisationIdeeDTO orga = null;
		OganisationIdeeDTO orgaBase = mapperOrganisationBase(grappe);
		if(orgaPetiteFille != null){
			orgaBase.getMapIdees().put(orgaPetiteFille.getId(), orgaPetiteFille);
		}
		else{
			orgaBase.getIdees().add(idee);
		}
		
		if(null != grappe.getGrappeParent()){
			
			orga= mappeOrganisation(grappe.getGrappeParent(),orgaBase,idee);	
		}
		else {
			orga = orgaBase;
			
		}
		
		return orga;
	}

	private OganisationIdeeDTO mapperOrganisationBase(GrappeEntity grappe) {
		OganisationIdeeDTO orgafille;
		orgafille = new OganisationIdeeDTO();
		orgafille.setId(grappe.getId());
		orgafille.setNom(grappe.getNom());
		orgafille.setDescription(grappe.getDescription());
		return orgafille;
	}

	private int retrouverOuCreerOrganisation(OganisationIdeeDTO organisation,
			GrappeEntity grappeEntityRecherche, GrappeEntity grappeEntity,
			IdeeEsclaveDTO idee) {

		if (organisation.getMapIdees().containsKey(grappeEntity.getId())) {

			OganisationIdeeDTO orga = organisation.getMapIdees().get(
					grappeEntity.getId());
			if (grappeEntityRecherche.getId() == grappeEntity.getId()) {
				orga.getIdees().add(idee);
				organisation.getMapIdees().replace(grappeEntity.getId(), orga);
				return 1;// retrouve et ajouté
			} else {
				System.out
						.println("mappe mappeEsclaves - grappe trouve, on passe aux filles");
				retrouverOuCreerOrganisation(orga, grappeEntityRecherche,
						grappeEntity, idee);
				return 2;// trouve, mais faut aller au fils
			}

		} else {

			return 3; // pas trouvé, mais c'est la bonne grappe
		}
	}

	private List<GrappeEntity> getOrdonneArbre(GrappeEntity grappe) {

		List<GrappeEntity> list = new ArrayList<GrappeEntity>();
		list.add(grappe);

		if (null != grappe.getGrappeParent()) {
			list.addAll(getOrdonneArbre(grappe.getGrappeParent()));
		}

		return list;
	}

	private IdeeEsclaveDTO mappeEsclave(AssociationIdeeEntity entity,
			TypeChargement typeChargement, int niveau) {
		IdeeEsclaveDTO retour = new IdeeEsclaveDTO();
		if (null != entity.getLiaison()) {
			retour.setLiaison(entity.getLiaison());
		}
		mappeOne(entity.getIdeeEsclave(), typeChargement, niveau);

		return retour;
	}

	public List<IdeeDTO> mappeAll(Iterable<IdeeEntity> entitys, int nbreNiveau) {
		List<IdeeDTO> retour = new ArrayList<IdeeDTO>();
		entitys.forEach(entity -> retour.add(mappeOne(entity,
				TypeChargement.BASIQUE, nbreNiveau)));
		return retour;
	}

	private void mappeBase(IdeeDTO retour, IdeeEntity entity) {

		retour.setId(entity.getId());
		retour.setNom(entity.getNom());
		retour.setDescription(entity.getDescription());

	}

	public List<IdeeDTO> mappeAssoIdees(List<AssociationGrappeEntity> entitys,
			TypeChargement typeChargement, int nbrNiveauIdee) {
		List<IdeeDTO> retour = new ArrayList<IdeeDTO>();
		for (AssociationGrappeEntity entity : entitys) {
			retour.add(mappeAssoIdee(entity, typeChargement, nbrNiveauIdee));
		}

		return retour;
	}

	private IdeeDTO mappeAssoIdee(AssociationGrappeEntity entity,
			TypeChargement typeChargement, int nbrNiveauIdee) {
		return mappeOne(entity.getIdee(), typeChargement, nbrNiveauIdee);
	}

	public IdeeEntity mappeEntity(CommunBodyDTO ideeDto) {
		IdeeEntity idee = new IdeeEntity();
		idee.setNom(ideeDto.getNom());
		idee.setDescription(ideeDto.getDescription());
		return idee;
		
	}

	public IdeeEntity mappeEntity(IdeeEntity ideeExistante, IdeePutBodyDTO ideeDto) {
		ideeExistante.setNom(ideeDto.getNom());
		ideeExistante.setDescription(ideeDto.getDescription());
		return ideeExistante;
	}
}
