package fr.pereirafrederic.storyline.application.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class UtilisateurDto extends CommunDTO {

    String nom;
    String email;
    Date dateInscription;

}
