package fr.grapidee.application.services.associationIdee;

import java.util.ArrayList;
import java.util.List;

import fr.grapidee.application.services.commun.CommunDTO;
import fr.grapidee.application.services.idee.IdeeDTO;

public class IdeeGrappeDTO extends CommunDTO {

	private List<IdeeDTO> listeIdee =new ArrayList<>();

	public List<IdeeDTO> getListeIdee() {
		return listeIdee;
	}

	public void setListeIdee(List<IdeeDTO> listeIdee) {
		this.listeIdee = listeIdee;
	}
	
	

	
		
}
