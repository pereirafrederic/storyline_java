package fr.storyline.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.storyline.application.entity.contenu.Evenement;

@RestController
@RequestMapping(value = "/storyline/user/{idUser}/evenement")
public class ControllerEvenement {

	@Autowired
	private ServiceEvenement serviceEvenement;

	@RequestMapping( method = RequestMethod.GET)
	@Transactional
	public Evenement recupererEvenement(
			@PathVariable(value = "id") Long id, @PathVariable(value = "idUser") Long idUser) {
		return this.serviceEvenement.recupererEvenement(id, idUser);
	}
	
	@RequestMapping(value = "/temps/{idTemps}/espace/{idEspace}", method = RequestMethod.GET)
	@Transactional
	public List<Evenement> recupererEvenement(@PathVariable(value = "idUser") Long idUser,
			@PathVariable(value = "idTemps") Long idTemps, @PathVariable(value = "idEspace") Long idEspace) {
		
		//TODO EVENEMENT LIGHT
		return this.serviceEvenement.recupererEvenements(idUser , idTemps,idEspace);
	}
}
