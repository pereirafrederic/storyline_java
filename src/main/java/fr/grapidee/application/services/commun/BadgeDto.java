package fr.grapidee.application.services.commun;


public class BadgeDto extends CommunDTO{

	private int nombre;
	private Long idDomaine;

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public Long getIdDomaine() {
		return idDomaine;
	}

	public void setIdDomaine(Long idDomaine) {
		this.idDomaine = idDomaine;
	}
	
	
	

}
