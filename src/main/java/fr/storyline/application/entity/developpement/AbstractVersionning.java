package fr.storyline.application.entity.developpement;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.checkerframework.checker.index.qual.Positive;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import fr.storyline.application.entity.commun.AbstractId;

@MappedSuperclass
public class AbstractVersionning extends AbstractId implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	@NotEmpty
	@NotNull
	@Length(min= 3, max =50)
	private String nom;
	
	@Positive
	@NotNull
	@Max(value=100)
	private Long numero;
	
	@NotNull
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
