package fr.grapidee.application.services.associationIdee;

import java.util.List;

import fr.grapidee.application.services.commun.CommunDTO;

public class IdeeDomaineDTO extends CommunDTO {

	private List<IdeeGrappeDTO> listeIdee;

	public List<IdeeGrappeDTO> getListeIdee() {
		return listeIdee;
	}

	public void setListeIdee(List<IdeeGrappeDTO> listeIdee) {
		this.listeIdee = listeIdee;
	}
	
}
