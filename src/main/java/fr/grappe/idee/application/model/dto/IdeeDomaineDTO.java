package fr.grappe.idee.application.model.dto;

import java.util.List;

public class IdeeDomaineDTO extends CommunDTO {

	private List<IdeeGrappeDTO> listeIdee;

	public List<IdeeGrappeDTO> getListeIdee() {
		return listeIdee;
	}

	public void setListeIdee(List<IdeeGrappeDTO> listeIdee) {
		this.listeIdee = listeIdee;
	}
	
}
