package fr.grapidee.application.services.entite.idee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/grapidee/idee")
public class ControllerIdee {

	@Autowired
	private IdeeService ideeService;

	/*@RequestMapping(method = RequestMethod.POST)
	public IdeeDTO creerIdee(@RequestBody IdeeBodyDTO idee) throws Exception {
		return this.ideeService.postOne(idee);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@Transactional
	public IdeeDTO majIdee(@RequestBody IdeeBodyDTO idee) throws Exception {
		return this.ideeService.putOne(idee);
	}
*/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Transactional
	public IdeeDTO recupererIdee(@PathVariable Long id ) {
		return this.ideeService.findOne(id);
	}

	@RequestMapping( method = RequestMethod.GET)
	public List<IdeeDTO>  recupererIdees() {		
		return this.ideeService.findAll();
	}
}
