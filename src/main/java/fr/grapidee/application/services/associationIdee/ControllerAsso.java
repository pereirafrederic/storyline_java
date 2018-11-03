package fr.grapidee.application.services.associationIdee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	/*
	@RequestMapping(method = RequestMethod.POST)
	public AssoBodyDTO creerAssoIdee(@RequestBody AssoIdeeBodyDTO assoIdee) throws Exception {
		return this.assoService.creerAssoIdee(assoIdee);
	}

	@RequestMapping(value = "/inject/{nomMaitre}/{nomEsclave}/{nomGrappe}", method = RequestMethod.GET)
	public AssoBodyDTO injecterAsso(@PathVariable String nomMaitre, @PathVariable String nomEsclave, @PathVariable String nomGrappe) throws Exception {
		return this.assoService.injecterAsso(nomMaitre, nomEsclave, nomGrappe);
	}
	
	*/
}
