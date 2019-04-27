package fr.storyline.application.dto;

import java.util.List;

public class VersionDto extends VersionningDto{
	
	
	private List<TexteDto> textes;

	public List<TexteDto> getTextes() {
		return textes;
	}

	public void setTextes(List<TexteDto> textes) {
		this.textes = textes;
	}

}
