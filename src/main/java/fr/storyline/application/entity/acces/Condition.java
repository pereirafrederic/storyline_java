package fr.storyline.application.entity.acces;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.storyline.application.entity.commun.AbstractId;
import fr.storyline.application.entity.contenu.Evenement;
import fr.storyline.application.entity.contenu.Livre;

@Entity(name = "Condition")
@Table(name = "condition_deblocage", schema = "storyline")
public class Condition extends AbstractId {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6422730408713046220L;
	
	@ManyToOne
	@JoinColumn(name = "ev_id")
	private Evenement evenementADebloquer;
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Livre Livre;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "condition", targetEntity = ConditionDetail.class)
	private List<ConditionDetail> details;

	public Evenement getEvenementADebloquer() {
		return evenementADebloquer;
	}

	public void setEvenementADebloquer(Evenement evenementADebloquer) {
		this.evenementADebloquer = evenementADebloquer;
	}

	public Livre getLivre() {
		return Livre;
	}

	public void setLivre(Livre livre) {
		Livre = livre;
	}

	public List<ConditionDetail> getDetails() {
		return details;
	}

	public void setDetails(List<ConditionDetail> details) {
		this.details = details;
	}


}
