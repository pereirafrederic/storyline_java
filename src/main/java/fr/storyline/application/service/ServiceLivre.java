package fr.storyline.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.storyline.application.entity.acces.AccesEvenement;
import fr.storyline.application.entity.contenu.Evenement;
import fr.storyline.application.entity.contenu.Livre;
import fr.storyline.application.entity.user.Utilisateur;

@Service
public class ServiceLivre {
	
	@Autowired
	private RepositoryLivre repoLivre;
	
	@Autowired
	private ServiceUtilisateur serviceUtilisateur;
	
	@Autowired
	private RepositoryAccesEvenement repositoryAccesEvenement;

	public Livre recupererLivre(Long id, Long idUser) {
		
		Utilisateur utilisateur = serviceUtilisateur.recupererUtilisateur(idUser);
		
		Boolean droitOk = utilisateur.getAccesLivres().stream().anyMatch( acces -> acces.getLivre().getId() == id);
		if(droitOk){
		return repoLivre.findOne(id);
		}
		
		return null;
	}

	public List<Evenement> recupererAccesEvenement(Long id, Long idUser) {
		Livre livre =recupererLivre(id, idUser);
		
		List<Evenement> retour= new ArrayList<Evenement>();
		livre.getEvenements().stream().forEach( evenement ->{
			List<AccesEvenement> accesEvenement =repositoryAccesEvenement.findByUtilisateurAndEvenement(idUser, evenement.getId());
			retour.add(accesEvenement.get(0).getEvenement());
			
		});
		
		return retour;
		
	}


}
