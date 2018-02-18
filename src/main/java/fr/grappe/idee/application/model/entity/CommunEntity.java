package fr.grappe.idee.application.model.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CommunEntity {
	  private static final long serialVersionUID = 1L;
	
	@Column(unique = true, nullable = false)
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
