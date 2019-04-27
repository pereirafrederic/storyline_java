package fr.storyline.application.entity.acces;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.storyline.application.entity.commun.AbstractId;

@Entity(name = "ConditionDetail")
@Table(name = "condition_detail", schema = "storyline")
public class ConditionDetail extends AbstractId {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6422730408713046220L;
	
	@ManyToOne
	@JoinColumn(name = "condition_id")
	private Condition condition;
	@ManyToOne
	@JoinColumn(name = "ae_id")
	private AccesEvenement conditionEvenement;
	
	@ManyToOne
	@JoinColumn(name = "al_id")
	private AccesLivre conditionLivre;

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public AccesEvenement getConditionEvenement() {
		return conditionEvenement;
	}

	public void setConditionEvenement(AccesEvenement conditionEvenement) {
		this.conditionEvenement = conditionEvenement;
	}

	public AccesLivre getConditionLivre() {
		return conditionLivre;
	}

	public void setConditionLivre(AccesLivre conditionLivre) {
		this.conditionLivre = conditionLivre;
	}	
	


}
