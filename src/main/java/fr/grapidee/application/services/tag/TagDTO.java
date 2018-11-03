package fr.grapidee.application.services.tag;

import java.util.ArrayList;
import java.util.List;

import fr.grapidee.application.services.commun.BadgeDto;
import fr.grapidee.application.services.commun.CommunDTO;
import fr.grapidee.application.services.idee.IdeeDTO;

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
