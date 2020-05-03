package fr.pereirafrederic.storyline.application.entity.contenu;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.pereirafrederic.storyline.application.entity.commun.AbstractId;
import fr.pereirafrederic.storyline.application.entity.developpement.Developpement;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity(name = "Evenement")
@Table(name = "evenement", schema = "storyline")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class Evenement extends AbstractId {
	
	
	
	
	/**
	 * 
	 */
	static final long serialVersionUID = -8457467724925851367L;

	String nom;
	
	
	@ManyToOne
	@JoinColumn(name = "space_id")
	Espace espace;
	
	@ManyToOne
	@JoinColumn(name = "time_id")
	Temps temps;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	Livre livre;
	
	@ManyToOne
	@JoinColumn(name = "dev_id")
	Developpement developpement;

}
