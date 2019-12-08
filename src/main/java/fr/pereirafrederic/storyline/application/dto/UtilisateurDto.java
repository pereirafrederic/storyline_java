package fr.pereirafrederic.storyline.application.dto;

import java.util.Date;

public class UtilisateurDto extends CommunDTO{
	
	private String nom;
	private String email;
	private Date dateInscription;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

}
