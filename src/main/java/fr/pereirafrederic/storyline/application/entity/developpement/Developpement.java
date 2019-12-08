package fr.pereirafrederic.storyline.application.entity.developpement;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.pereirafrederic.storyline.application.entity.commun.AbstractId;

@Entity(name = "Developpement")
@Table(name = "developpement", schema = "storyline")
public class Developpement extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7651345125628872606L;
	
	@ManyToOne
	@JoinColumn(name = "version_id")
	private Version version;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "developpement", targetEntity = Version.class)
	private List<Version> archives;

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public List<Version> getArchives() {
		return archives;
	}

	public void setArchives(List<Version> archives) {
		this.archives = archives;
	}



}
