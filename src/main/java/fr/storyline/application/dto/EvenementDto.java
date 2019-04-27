package fr.storyline.application.dto;

public class EvenementDto extends CommunDTO{
	
	private String nom;
	private VersionDto version;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public VersionDto getVersion() {
		return version;
	}
	public void setVersion(VersionDto version) {
		this.version = version;
	}

}
