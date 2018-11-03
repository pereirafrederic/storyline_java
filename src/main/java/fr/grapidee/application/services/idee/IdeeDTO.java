package fr.grapidee.application.services.idee;

import java.util.ArrayList;
import java.util.List;

import fr.grapidee.application.services.associationIdee.IdeeDomaineDTO;
import fr.grapidee.application.services.associationIdee.IdeeGrappeDTO;
import fr.grapidee.application.services.commun.BadgeDto;
import fr.grapidee.application.services.commun.CommunDTO;
import fr.grapidee.application.services.tag.TagDTO;

public class IdeeDTO extends CommunDTO {

	private int level;
	private Boolean projet;
	private String contenu;

	private TagDTO tag;
	
	private List<IdeeDomaineDTO> listeDomaine;
	private List<IdeeGrappeDTO> listeGrappe;
	private List<IdeeDTO> listeEsclave;
	private List<BadgeDto> listeBadge =new ArrayList<>();
	
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public List<IdeeDTO> getListeEsclave() {
		return listeEsclave;
	}
	public void setListeEsclave(List<IdeeDTO> listeEsclave) {
		this.listeEsclave = listeEsclave;
	}
	public Boolean getProjet() {
		return projet;
	}
	public void setProjet(Boolean projet) {
		this.projet = projet;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public List<BadgeDto> getListeBadge() {
		return listeBadge;
	}
	public void setListeBadge(List<BadgeDto> listeBadge) {
		this.listeBadge = listeBadge;
	}
	public TagDTO getTag() {
		return tag;
	}
	public void setTag(TagDTO tag) {
		this.tag = tag;
	}
	public List<IdeeDomaineDTO> getListeDomaine() {
		return listeDomaine;
	}
	public void setListeDomaine(List<IdeeDomaineDTO> listeDomaine) {
		this.listeDomaine = listeDomaine;
	}
	public List<IdeeGrappeDTO> getListeGrappe() {
		return listeGrappe;
	}
	public void setListeGrappe(List<IdeeGrappeDTO> listeGrappe) {
		this.listeGrappe = listeGrappe;
	}

}
