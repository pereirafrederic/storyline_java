package fr.pereirafrederic.storyline.application.dto;

import fr.pereirafrederic.storyline.application.entity.developpement.EnumEtatEcriture;

public class VersionningDto extends CommunDTO{

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public EnumEtatEcriture getEtat() {
		return etat;
	}
	public void setEtat(EnumEtatEcriture etat) {
		this.etat = etat;
	}
	private String nom;
	private Long numero;
	private EnumEtatEcriture etat;
}
