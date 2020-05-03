package fr.pereirafrederic.storyline.application.entity.acces;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.pereirafrederic.storyline.application.entity.commun.AbstractId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity(name = "ConditionDetail")
@Table(name = "condition_detail", schema = "storyline")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class ConditionDetail extends AbstractId {

	
	/**
	 * 
	 */
	static final long serialVersionUID = -6422730408713046220L;
	
	@ManyToOne
	@JoinColumn(name = "condition_id")
	Condition condition;
	@ManyToOne
	@JoinColumn(name = "ae_id")
	AccesEvenement conditionEvenement;
	
	@ManyToOne
	@JoinColumn(name = "al_id")
	AccesLivre conditionLivre;

}
