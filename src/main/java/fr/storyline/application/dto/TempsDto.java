package fr.storyline.application.dto;

public class TempsDto extends CommunDTO{
	private Long annee;
	private Long jour;
	public Long getAnnee() {
		return annee;
	}
	public void setAnnee(Long annee) {
		this.annee = annee;
	}
	public Long getJour() {
		return jour;
	}
	public void setJour(Long jour) {
		this.jour = jour;
	}
}
