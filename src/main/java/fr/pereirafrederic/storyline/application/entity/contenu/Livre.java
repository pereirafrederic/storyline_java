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

@Entity(name = "Livre")
@Table(name = "livre", schema = "storyline")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class Livre extends AbstractId {

	static final long serialVersionUID = -8457467724925851367L;
	
	String nom;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "livre", targetEntity = Evenement.class)
	List<Evenement> evenements;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "livre", targetEntity = Espace.class)
	List<Espace> espace;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "livre", targetEntity = Temps.class)
	List<Temps> temps;
	
	@ManyToOne
	@JoinColumn(name = "collect_id")
	CollectionLivre collectionLivre;
	
}
