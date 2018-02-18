package fr.grappe.idee.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.grappe.idee.application.model.body.IdeeBodyDTO;
import fr.grappe.idee.application.model.dto.IdeeDTO;
import fr.grappe.idee.application.service.IdeeService;
import utils.params.RequestParamUtils;

@RestController
@RequestMapping(value = "/grapidee/idee")
public class ControllerIdee {

	@Autowired
	private IdeeService ideeService;

	@RequestMapping(method = RequestMethod.POST)
	public IdeeDTO creerIdee(@RequestBody IdeeBodyDTO idee) {
		return this.ideeService.postOne(idee);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public IdeeDTO recupererIdee(@PathVariable Long id,
			@RequestParam(value = "niveauInferieur", required = false) Integer niveauInferieur) {
		niveauInferieur = RequestParamUtils.getNiveauInferieur(niveauInferieur);
		return this.ideeService.findOne(id, niveauInferieur);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public IdeeDTO majIdee(@RequestBody IdeeBodyDTO idee) {
		return this.ideeService.putOne(idee);
	}

	@RequestMapping(value = "/inject/{nom}/{contenu}", method = RequestMethod.GET)
	public IdeeDTO injecterIdee(@PathVariable String nom, @PathVariable String contenu) throws Exception {
		return this.ideeService.injecterIdee(nom, contenu, null);
	}
	
	@RequestMapping(value = "/inject/{nom}/{contenu}/{tag}", method = RequestMethod.GET)
	public IdeeDTO injecterIdee(@PathVariable String nom, @PathVariable String contenu, @PathVariable String tag) throws Exception {
		return this.ideeService.injecterIdee(nom, contenu, tag);
	}
	
	@RequestMapping(value = "/asso/{nomIdee}/{tag}", method = RequestMethod.GET)
	public IdeeDTO assoTag(@PathVariable String nomIdee, @PathVariable String tag) throws Exception {
		return this.ideeService.injecterIdee(nomIdee,null, tag);
	}	
}
