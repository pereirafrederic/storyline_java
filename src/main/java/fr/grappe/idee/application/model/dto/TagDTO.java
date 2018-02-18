package fr.grappe.idee.application.model.dto;

import java.util.ArrayList;
import java.util.List;

public class TagDTO extends CommunDTO {

	private List<IdeeDTO> listeIdee =new ArrayList<>();
	private List<BadgeDto> listeBadge =new ArrayList<>();

	public List<IdeeDTO> getListeIdee() {
		return listeIdee;
	}

	public void setListeIdee(List<IdeeDTO> listeIdee) {
		this.listeIdee = listeIdee;
	}
	
	public List<BadgeDto> getListeBadge() {
		return listeBadge;
	}

	public void setListeBadge(List<BadgeDto> listeBadge) {
		this.listeBadge = listeBadge;
	}
	
	
	

	
		
}
