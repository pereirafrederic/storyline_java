package fr.grappe.idee.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.grappe.idee.application.model.body.TagBodyDTO;
import fr.grappe.idee.application.model.dto.CommunDTO;
import fr.grappe.idee.application.model.dto.GrappeDTO;
import fr.grappe.idee.application.model.dto.IdeeDTO;
import fr.grappe.idee.application.model.dto.TagDTO;
import fr.grappe.idee.application.service.IdeeService;
import fr.grappe.idee.application.service.TagService;
import utils.params.RequestParamUtils;

@RestController
@RequestMapping(value = "/grapidee/tag")
public class ControllerTag {

	
	@Autowired
	private TagService tagService;
		
	@RequestMapping( method = RequestMethod.GET)
	public List<CommunDTO> recupererTousTag() {
		return this.tagService.findAll();
	}
	@RequestMapping(method = RequestMethod.POST)
	public TagDTO creerTag(@RequestBody TagBodyDTO tag) {
		return this.tagService.postOne(tag);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TagDTO recupererGrappe(@PathVariable Long id, @RequestParam (value="niveauInferieur", required=false) Integer niveauInferieur ) {
		niveauInferieur = RequestParamUtils.getNiveauInferieur(niveauInferieur);
		return this.tagService.findOne(id, niveauInferieur);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public TagDTO majTag(@RequestBody  TagBodyDTO tag) {
		return this.tagService.putOne(tag);
	}
	
	
	@RequestMapping(value = "/inject/{nom}", method = RequestMethod.GET)
	public TagDTO injecterTag(@PathVariable String nom) throws Exception {
		return this.tagService.injecterTag(nom, null);
	}
	
	@RequestMapping(value = "/inject/{nom}/{grappe}", method = RequestMethod.GET)
	public TagDTO injecterTag(@PathVariable String nom, @PathVariable String grappe) throws Exception {
		return this.tagService.injecterTag(nom, grappe);
	}
}
