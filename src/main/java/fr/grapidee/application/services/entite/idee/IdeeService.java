package fr.grapidee.application.services.entite.idee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdeeService  {

	@Autowired
	private IdeeRepository repo;
	
	@Autowired
	private MapperIdee mapper;
	
	public IdeeDTO findOne(Long id) {
		return mapper.mappeOne(repo.findOne(id), true);
	}

	public List<IdeeDTO> findAll() {
		return mapper.mappeAll(repo.findAll(), true);
	}
}
