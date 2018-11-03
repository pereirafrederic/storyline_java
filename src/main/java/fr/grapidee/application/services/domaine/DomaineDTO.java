package fr.grapidee.application.services.domaine;

import java.util.ArrayList;
import java.util.List;

import fr.grapidee.application.services.commun.BadgeDto;
import fr.grapidee.application.services.commun.CommunDTO;
import fr.grapidee.application.services.grappe.GrappeDTO;

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
