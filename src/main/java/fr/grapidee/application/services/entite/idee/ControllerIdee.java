package fr.grapidee.application.services.entite.idee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.grapidee.application.services.commun.CommunBodyDTO;
import fr.grapidee.application.services.commun.TypeChargement;
import fr.grapidee.application.services.entite.grappe.GrappeBodyDTO;
import fr.grapidee.application.services.entite.grappe.GrappeDTO;

@RestController
@RequestMapping(value = "/grapidee/idee")
public class ControllerIdee {

	@Autowired
	private IdeeService ideeService;

	@RequestMapping(value = "/{id}/{typeChargement}", method = RequestMethod.GET)
	@Transactional
	public IdeeDTO recupererIdee(
			@PathVariable(value = "id") Long id,
			@PathVariable(value = "typeChargement") TypeChargement typeChargement) {
		return this.ideeService.findOne(id, typeChargement);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<IdeeDTO> recupererIdees() {
		return this.ideeService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public IdeeDTO creerIdee(@RequestBody IdeeBodyDTO idee) throws Exception {
		return this.ideeService.postOne(idee);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@Transactional
	public IdeeDTO majIdee(@RequestBody IdeePutBodyDTO idee) throws Exception {
		return this.ideeService.putOne(idee);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	@Transactional
	public void deleteIdee(@RequestBody IdeeBodyDTO idee)
			throws Exception {
		this.ideeService.deleteOne(idee);
	}
	
}
