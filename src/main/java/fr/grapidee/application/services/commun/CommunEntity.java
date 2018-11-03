package fr.grapidee.application.services.commun;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CommunEntity extends AbstractId{
	  private static final long serialVersionUID = 1L;
		  
	@Column(unique = true, nullable = false, length = 50)
	private String nom;
	
	@Column(length = 1000)
	private String description;
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
