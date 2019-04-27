package fr.storyline.application.entity.developpement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Texte")
@Table(name = "texte", schema = "storyline")
public class Texte extends AbstractVersionning {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7651345125628872606L;
	
	@ManyToOne
	@JoinColumn(name = "version_id")
	private Version version;
	
	private Long ordre;
	
	@Column(length = 100,name="essai_1")
	private String essai1;
	@Column(length = 250,name="essai_2")
	private String essai2;
	@Column(length = 500,name="essai_3")
	private String essai3;
	@Column(length = 1000,name="essai_4")
	private String essai4;
	@Column(length = 2000,name="essai_5")
	private String essai5;
	@Column(length = 4000,name="essai_6")
	private String essai6;
	@Column(length = 10000,name="essai_7")
	private String essai7;
	public Version getVersion() {
		return version;
	}
	public void setVersion(Version version) {
		this.version = version;
	}
	public Long getOrdre() {
		return ordre;
	}
	public void setOrdre(Long ordre) {
		this.ordre = ordre;
	}
	public String getEssai1() {
		return essai1;
	}
	public void setEssai1(String essai1) {
		this.essai1 = essai1;
	}
	public String getEssai2() {
		return essai2;
	}
	public void setEssai2(String essai2) {
		this.essai2 = essai2;
	}
	public String getEssai3() {
		return essai3;
	}
	public void setEssai3(String essai3) {
		this.essai3 = essai3;
	}
	public String getEssai4() {
		return essai4;
	}
	public void setEssai4(String essai4) {
		this.essai4 = essai4;
	}
	public String getEssai5() {
		return essai5;
	}
	public void setEssai5(String essai5) {
		this.essai5 = essai5;
	}
	public String getEssai6() {
		return essai6;
	}
	public void setEssai6(String essai6) {
		this.essai6 = essai6;
	}
	public String getEssai7() {
		return essai7;
	}
	public void setEssai7(String essai7) {
		this.essai7 = essai7;
	}


}
