package fr.grappe.idee.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.grappe.idee.application.model.body.AssoBodyDTO;
import fr.grappe.idee.application.model.body.AssoIdeeBodyDTO;
import fr.grappe.idee.application.service.AssoService;

@RestController
@RequestMapping(value = "/grapidee/asso")
public class ControllerAsso {
	
	@Autowired
	private AssoService assoService;
	
		
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public AssoBodyDTO majAsso(@RequestBody AssoBodyDTO asso) {
		return this.assoService.putOne(asso);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public AssoBodyDTO associer(@RequestBody AssoBodyDTO asso) throws Exception {
		return this.assoService.postOne(asso);
	}
	
	@RequestMapping(value = "/asso-idee", method = RequestMethod.POST)
	public AssoBodyDTO creerAssoIdee(@RequestBody AssoIdeeBodyDTO assoIdee) throws Exception {
		return this.assoService.creerAssoIdee(assoIdee);
	}
	
	@RequestMapping(value = "/inject/{nomMaitre}/{nomEsclave}/{nomGrappe}", method = RequestMethod.GET)
	public AssoBodyDTO injecterAsso(@PathVariable String nomMaitre, @PathVariable String nomEsclave, @PathVariable String nomGrappe) throws Exception {
		return this.assoService.injecterAsso(nomMaitre, nomEsclave, nomGrappe);
	}
	
	
}
