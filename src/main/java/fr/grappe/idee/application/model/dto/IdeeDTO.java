package fr.grappe.idee.application.model.dto;

import java.util.List;

public class IdeeDTO extends CommunDTO {

	private int level;
	private Boolean projet;
	private String contenu;

	private List<IdeeDTO> listeEsclave;
	
	
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

}
