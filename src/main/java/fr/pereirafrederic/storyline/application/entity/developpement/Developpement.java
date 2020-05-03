package fr.pereirafrederic.storyline.application.entity.developpement;

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

@Entity(name = "Developpement")
@Table(name = "developpement", schema = "storyline")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class Developpement extends AbstractId {

	/**
	 * 
	 */
	static final long serialVersionUID = 7651345125628872606L;
	
	@ManyToOne
	@JoinColumn(name = "version_id")
	Version version;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "developpement", targetEntity = Version.class)
	List<Version> archives;



}
