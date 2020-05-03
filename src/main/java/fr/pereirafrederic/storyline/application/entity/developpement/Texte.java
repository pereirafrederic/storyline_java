package fr.pereirafrederic.storyline.application.entity.developpement;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Texte")
@Table(name = "texte", schema = "storyline")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class Texte extends AbstractVersionning {

	/**
	 * 
	 */
	static final long serialVersionUID = 7651345125628872606L;
	
	@ManyToOne
	@JoinColumn(name = "version_id")
	Version version;
	
	Long ordre;
	
	@Column(length = 100,name="essai_1")
	String essai1;
	@Column(length = 250,name="essai_2")
	String essai2;
	@Column(length = 500,name="essai_3")
	String essai3;
	@Column(length = 1000,name="essai_4")
	String essai4;
	@Column(length = 2000,name="essai_5")
	String essai5;
	@Column(length = 4000,name="essai_6")
	String essai6;
	@Column(length = 10000,name="essai_7")
	String essai7;
}
