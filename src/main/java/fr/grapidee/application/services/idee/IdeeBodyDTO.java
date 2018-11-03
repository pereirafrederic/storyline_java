package fr.grapidee.application.services.idee;

import fr.grapidee.application.services.commun.CommunDTO;

public class IdeeBodyDTO extends CommunDTO {

	private String contenu;
	private Long idTag;

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Long getIdTag() {
		return idTag;
	}

	public void setIdTag(Long idTag) {
		this.idTag = idTag;
	}

}
