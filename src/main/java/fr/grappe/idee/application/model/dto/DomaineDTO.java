package fr.grappe.idee.application.model.dto;

import java.util.ArrayList;
import java.util.List;

public class DomaineDTO extends CommunDTO {
	private List<GrappeDTO> listeGrappe= new ArrayList<GrappeDTO>();
	private List<BadgeDto> listeBadge =new ArrayList<>();
	

	public List<GrappeDTO> getListeGrappe() {
		return listeGrappe;
	}

	public void setListeGrappe(List<GrappeDTO> listeGrappe) {
		this.listeGrappe = listeGrappe;
	}
	public List<BadgeDto> getListeBadge() {
		return listeBadge;
	}

	public void setListeBadge(List<BadgeDto> listeBadge) {
		this.listeBadge = listeBadge;
	}

	
	
	
}
