package fr.pereirafrederic.storyline.application.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class TexteDto extends VersionningDto {

    Long ordre;


    String essai1;

    String essai2;

    String essai3;

    String essai4;

    String essai5;

    String essai6;

    String essai7;
}
