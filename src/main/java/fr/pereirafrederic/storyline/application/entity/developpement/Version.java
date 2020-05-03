package fr.pereirafrederic.storyline.application.entity.developpement;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Version")
@Table(name = "version", schema = "storyline")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class Version extends AbstractVersionning {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7651345125628872606L;

	@ManyToOne
	@JoinColumn(name = "dev_id")
	Developpement developpement;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "version", targetEntity = Texte.class)
	List<Texte> textes;

}
