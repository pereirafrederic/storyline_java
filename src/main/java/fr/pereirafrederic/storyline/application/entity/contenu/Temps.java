package fr.pereirafrederic.storyline.application.entity.contenu;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.pereirafrederic.storyline.application.entity.commun.AbstractId;

@Entity(name = "Temps")
@Table(name = "temps", schema = "storyline")
public class Temps extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7651345125628872606L;
	
	private Long annee;
	private Long jour;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "temps", targetEntity = Evenement.class)
	private List<Evenement> evenements;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Livre livre;

	public Long getAnnee() {
		return annee;
	}

	public void setAnnee(Long annee) {
		this.annee = annee;
	}

	public Long getJour() {
		return jour;
	}

	public void setJour(Long jour) {
		this.jour = jour;
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
