package fr.grappe.idee.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.grappe.idee.application.model.dto.CommunDTO;
import fr.grappe.idee.application.model.dto.DomaineDTO;
import fr.grappe.idee.application.model.dto.GrappeDTO;
import fr.grappe.idee.application.model.dto.IdeeDTO;
import fr.grappe.idee.application.service.DomaineService;
import fr.grappe.idee.application.service.GrappeService;
import fr.grappe.idee.application.service.IdeeService;

@RestController
@RequestMapping(value = "/grapidee")
public class Controller {

	
	@Autowired
	private DomaineService domaineService;
	
	@Autowired
	private GrappeService grappeService;

	
	@Autowired
	private IdeeService ideeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String test() {
		return "ok";
	}
	
	
	@RequestMapping(value = "/domaine", method = RequestMethod.GET)
	public List<CommunDTO> recupererToutesDomaines() {
		return this.domaineService.findAll();
	}
	
	@RequestMapping(value = "/domaine/{id}", method = RequestMethod.GET)
	public DomaineDTO recupererDomaine(@PathVariable Long id) {
		return this.domaineService.findOne(id);
	}

	@RequestMapping(value = "/grappe", method = RequestMethod.GET)
	public List<CommunDTO> recupererToutesGrappes() {
		return this.grappeService.findAll();
	}

	@RequestMapping(value = "/grappe/{id}", method = RequestMethod.GET)
	public GrappeDTO recupererGrappe(@PathVariable Long id) {
		return this.grappeService.findOne(id);
	}
	

	@RequestMapping(value = "/idee/{id}", method = RequestMethod.GET)
	public IdeeDTO recupererIdee(@PathVariable Long id, @RequestParam (value="niveauInferieur", required=true) final int niveauInferieur ) {
		return this.ideeService.findOne(id, niveauInferieur);
	}
	

	
	
}
