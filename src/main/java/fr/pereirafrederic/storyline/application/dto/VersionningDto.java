package fr.pereirafrederic.storyline.application.dto;

import fr.pereirafrederic.storyline.application.entity.developpement.EnumEtatEcriture;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class VersionningDto extends CommunDTO {

    String nom;
    Long numero;
    EnumEtatEcriture etat;
}
