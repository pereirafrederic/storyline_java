package fr.storyline.application.entity.contenu;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.storyline.application.entity.commun.AbstractId;

@Entity(name = "Espace")
@Table(name = "espace", schema = "storyline")
public class Espace extends AbstractId {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6422730408713046220L;
	
	private String nom;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "espace", targetEntity = Evenement.class)
	private List<Evenement> evenements;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Livre livre;

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

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	
	


}
