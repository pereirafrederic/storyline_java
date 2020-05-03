package fr.pereirafrederic.storyline.application.entity.acces;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.pereirafrederic.storyline.application.entity.commun.AbstractId;
import fr.pereirafrederic.storyline.application.entity.contenu.Evenement;
import fr.pereirafrederic.storyline.application.entity.contenu.Livre;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity(name = "Condition")
@Table(name = "condition_deblocage", schema = "storyline")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class Condition extends AbstractId {

	
	/**
	 * 
	 */
	static final long serialVersionUID = -6422730408713046220L;
	
	@ManyToOne
	@JoinColumn(name = "ev_id")
	Evenement evenementADebloquer;
	@ManyToOne
	@JoinColumn(name = "book_id")
	Livre Livre;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "condition", targetEntity = ConditionDetail.class)
	List<ConditionDetail> details;
}
