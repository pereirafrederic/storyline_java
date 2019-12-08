package fr.pereirafrederic.storyline.application.dto;

public class LivreLightDto extends CommunDTO{
	
	private String nom;
	private String collection;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}

}
