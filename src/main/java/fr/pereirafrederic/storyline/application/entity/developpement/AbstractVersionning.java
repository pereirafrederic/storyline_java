package fr.pereirafrederic.storyline.application.entity.developpement;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import fr.pereirafrederic.storyline.application.entity.commun.AbstractId;

@MappedSuperclass
public class AbstractVersionning extends AbstractId implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String nom;
	private Long numero;
	private EnumEtatEcriture etat;
	
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


}
