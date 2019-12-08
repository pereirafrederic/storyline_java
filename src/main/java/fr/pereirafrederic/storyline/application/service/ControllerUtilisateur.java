package fr.pereirafrederic.storyline.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pereirafrederic.storyline.application.entity.contenu.Livre;
import fr.pereirafrederic.storyline.application.entity.user.Utilisateur;

@RestController
@RequestMapping(value = "/storyline/user")
public class ControllerUtilisateur {

	@Autowired
	private ServiceUtilisateur serviceUtilisateur;
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Transactional
	public Utilisateur recupererUtilisateur(
			@PathVariable(value = "id") Long id) throws Exception {
		return this.serviceUtilisateur.recupererUtilisateur(id);
	}
	
	@RequestMapping(value = "/{id}/livres", method = RequestMethod.GET)
	@Transactional
	public List<Livre> recupererLivres(
			@PathVariable(value = "id") Long id) throws Exception {
		//TODO LIVRE LIGHT
		return this.serviceUtilisateur.recupererLivres(id);
	}
	
}
