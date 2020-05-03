package fr.pereirafrederic.storyline.application.entity.contenu;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.pereirafrederic.storyline.application.entity.commun.AbstractId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity(name = "CollectionLivre")
@Table(name = "collection_livre", schema = "storyline")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class CollectionLivre extends AbstractId {

	static final long serialVersionUID = -8457467724925851367L;
	
	String nom;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "collectionLivre", targetEntity = Livre.class)
	List<Livre> livres;
	}
