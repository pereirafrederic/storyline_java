package fr.pereirafrederic.storyline.application.entity.developpement;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import fr.pereirafrederic.storyline.application.entity.commun.AbstractId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@MappedSuperclass
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AbstractVersionning extends AbstractId implements Serializable {
	static final long serialVersionUID = 1L;

	
	String nom;
	Long numero;
	EnumEtatEcriture etat;


}
