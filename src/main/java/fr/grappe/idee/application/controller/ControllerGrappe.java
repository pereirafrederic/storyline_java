package fr.grappe.idee.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.grappe.idee.application.model.body.GrappeBodyDTO;
import fr.grappe.idee.application.model.dto.CommunDTO;
import fr.grappe.idee.application.model.dto.GrappeDTO;
import fr.grappe.idee.application.service.GrappeService;
import utils.params.RequestParamUtils;

@RestController
@RequestMapping(value = "/grapidee/grappe")
public class ControllerGrappe {

	@Autowired
	private GrappeService grappeService;
	
		@RequestMapping( method = RequestMethod.GET)
	public List<CommunDTO> recupererToutesGrappes() {
		return this.grappeService.findAll();
	}
	@RequestMapping( method = RequestMethod.POST)
	public GrappeDTO creerGrappe(@RequestBody GrappeBodyDTO grappe) {
		return this.grappeService.postOne(grappe);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public GrappeDTO recupererGrappe(@PathVariable Long id, @RequestParam (value="niveauInferieur", required=false) Integer niveauInferieur ) {
		niveauInferieur = RequestParamUtils.getNiveauInferieur(niveauInferieur);
		return this.grappeService.findOne(id, niveauInferieur);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public GrappeDTO majGrappe(@RequestBody GrappeBodyDTO grappe) {
		return this.grappeService.putOne(grappe);
	}

	
	@RequestMapping(value = "/inject/{nom}", method = RequestMethod.GET)
	public GrappeDTO injecterGrappe(@PathVariable String nom) throws Exception {
		return this.grappeService.injecterGrappe(nom, null);
	}
	
	@RequestMapping(value = "/inject/{nom}/{domaine}", method = RequestMethod.GET)
	public GrappeDTO injecterGrappe(@PathVariable String nom, @PathVariable String domaine) throws Exception {
		return this.grappeService.injecterGrappe(nom, domaine);
	}
	
}
