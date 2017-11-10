package fr.grappe.idee.application.model.dto;

import java.util.ArrayList;
import java.util.List;

public class DomaineDTO extends CommunDTO {

	
	private List<GrappeDTO> listeGrappe= new ArrayList<GrappeDTO>();
	

	public List<GrappeDTO> getListeGrappe() {
		return listeGrappe;
	}

	public void setListeGrappe(List<GrappeDTO> listeGrappe) {
		this.listeGrappe = listeGrappe;
	}}
