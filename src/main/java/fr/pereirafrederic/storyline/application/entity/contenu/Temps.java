package fr.pereirafrederic.storyline.application.entity.contenu;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.pereirafrederic.storyline.application.entity.commun.AbstractId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity(name = "Temps")
@Table(name = "temps", schema = "storyline")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class Temps extends AbstractId {

	/**
	 * 
	 */
	static final long serialVersionUID = 7651345125628872606L;
	
	Long annee;
	Long jour;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "temps", targetEntity = Evenement.class)
	List<Evenement> evenements;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	Livre livre;

}
