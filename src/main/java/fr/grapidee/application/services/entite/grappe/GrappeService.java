package fr.grapidee.application.services.entite.grappe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grapidee.application.services.commun.dto.CommunDTO;

@Service
public class GrappeService {

	
	@Autowired
	private GrappeRepository repo;

	@Autowired
	private MapperGrappe mapper;
	
	public GrappeDTO findOne(Long id) {
		return mapper.mappeOne(repo.findOne(id), true);
	}

	public List<CommunDTO> findAll() {
		return mapper.mappeAll(repo.findAll());
	}



}
