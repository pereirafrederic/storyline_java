package fr.pereirafrederic.storyline.application.entity.contenu;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.pereirafrederic.storyline.application.entity.commun.AbstractId;
import fr.pereirafrederic.storyline.application.entity.developpement.Developpement;

@Entity(name = "Evenement")
@Table(name = "evenement", schema = "storyline")
public class Evenement extends AbstractId {
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8457467724925851367L;

	private String nom;
	
	
	@ManyToOne
	@JoinColumn(name = "space_id")
	private Espace espace;
	
	@ManyToOne
	@JoinColumn(name = "time_id")
	private Temps temps;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Livre livre;
	
	@ManyToOne
	@JoinColumn(name = "dev_id")
	private Developpement developpement;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Espace getEspace() {
		return espace;
	}

	public void setEspace(Espace espace) {
		this.espace = espace;
	}

	public Temps getTemps() {
		return temps;
	}

	public void setTemps(Temps temps) {
		this.temps = temps;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Developpement getDeveloppement() {
		return developpement;
	}

	public void setDeveloppement(Developpement developpement) {
		this.developpement = developpement;
	}
	


}
