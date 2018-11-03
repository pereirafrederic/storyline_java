package fr.grapidee.application.services.commun;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.grapidee.application.services.domaine.DomaineEntity;
import fr.grapidee.application.services.grappe.GrappeEntity;
import fr.grapidee.application.services.tag.TagEntity;

@Service
public class MapperCombox {

	public List<CommunDTO> mapperDomaine(final List<DomaineEntity> entites) {
		List<CommunDTO> listeRetour = new ArrayList<>();
		if (null != entites) {
			for (DomaineEntity domaineEntity : entites) {
				listeRetour.add(this.mapperDomaine(domaineEntity));
			}
		}
		return listeRetour;

	}

	public List<CommunDTO> mapperGrappe(final List<GrappeEntity> entites) {
		List<CommunDTO> listeRetour = new ArrayList<>();
		if (null != entites) {
			for (GrappeEntity grappeEntite : entites) {
				listeRetour.add(this.mapperGrappe(grappeEntite));
			}
		}
		return listeRetour;

	}
	public List<CommunDTO> mapperTag(List<TagEntity> entites) {
		List<CommunDTO> listeRetour = new ArrayList<>();
		if (null != entites) {
			for (TagEntity tagEntity : entites) {
				listeRetour.add(this.mapperTag(tagEntity));
			}
		}
		return listeRetour;
	}

	private CommunDTO mapperTag(TagEntity entite) {
		 return this.mapper(entite.getId(), entite.getNom());
	}

	public CommunDTO mapperDomaine(final DomaineEntity entite) {
		return this.mapper(entite.getId(), entite.getNom());
	}

	public CommunDTO mapperGrappe(final GrappeEntity entite) {
		return this.mapper(entite.getId(), entite.getNom());
	}

	private CommunDTO mapper(Long id, String nom) {
		CommunDTO dto = new CommunDTO();
		dto.setId(id);
		dto.setNom(nom);

		return dto;
	}


}
