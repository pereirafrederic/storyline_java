package fr.storyline.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.storyline.application.entity.contenu.Evenement;
import fr.storyline.application.entity.contenu.Livre;

@RestController
@RequestMapping(value = "/storyline/user/{idUser}/livre/{id}")
public class ControllerLivre {

	@Autowired
	private ServiceLivre serviceLivre;

	@RequestMapping( method = RequestMethod.GET)
	@Transactional
	public Livre recupererLivre(
			@PathVariable(value = "id") Long id, @PathVariable(value = "idUser") Long idUser) {
		return this.serviceLivre.recupererLivre(id, idUser);
	}
	
	@RequestMapping(value = "/evenements", method = RequestMethod.GET)
	@Transactional
	public List<Evenement> recupererAccesEvenement(
			@PathVariable(value = "id") Long id, @PathVariable(value = "idUser") Long idUser) {
		
		//TODO EVENEMENT LIGHT
		return this.serviceLivre.recupererAccesEvenement(id, idUser);
	}
}
