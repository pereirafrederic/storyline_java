package fr.grappe.idee.application.model.dto;

import java.util.ArrayList;
import java.util.List;

public class GrappeDTO extends CommunDTO {

	
	private List<IdeeDTO> listeIdee =new ArrayList<>();

	public List<IdeeDTO> getListeIdee() {
		return listeIdee;
	}

	public void setListeIdee(List<IdeeDTO> listeIdee) {
		this.listeIdee = listeIdee;
	}
	
	

	
		
}
