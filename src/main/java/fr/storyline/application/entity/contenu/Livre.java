package fr.storyline.application.entity.contenu;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.storyline.application.entity.commun.AbstractId;

@Entity(name = "Livre")
@Table(name = "livre", schema = "storyline")
public class Livre extends AbstractId {
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8457467724925851367L;
	
	private String nom;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "livre", targetEntity = Evenement.class)
	private List<Evenement> evenements;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "livre", targetEntity = Espace.class)
	private List<Espace> espace;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "livre", targetEntity = Temps.class)
	private List<Temps> temps;
	
	@ManyToOne
	@JoinColumn(name = "collect_id")
	private CollectionLivre collectionLivre;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}

	public List<Espace> getEspace() {
		return espace;
	}

	public void setEspace(List<Espace> espace) {
		this.espace = espace;
	}

	public List<Temps> getTemps() {
		return temps;
	}

	public void setTemps(List<Temps> temps) {
		this.temps = temps;
	}

	public CollectionLivre getCollectionLivre() {
		return collectionLivre;
	}

	public void setCollectionLivre(CollectionLivre collectionLivre) {
		this.collectionLivre = collectionLivre;
	}
	
}
