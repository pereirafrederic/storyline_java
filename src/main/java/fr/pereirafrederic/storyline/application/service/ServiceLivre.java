package fr.pereirafrederic.storyline.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pereirafrederic.storyline.application.entity.acces.AccesEvenement;
import fr.pereirafrederic.storyline.application.entity.contenu.Evenement;
import fr.pereirafrederic.storyline.application.entity.contenu.Livre;
import fr.pereirafrederic.storyline.application.entity.user.Utilisateur;

@Service
public class ServiceLivre {
	
	@Autowired
	private RepositoryLivre repoLivre;
	
	@Autowired
	private ServiceUtilisateur serviceUtilisateur;
	
	@Autowired
	private RepositoryAccesEvenement repositoryAccesEvenement;

	public Livre recupererLivre(Long id, Long idUser) throws Exception {
		
		Utilisateur utilisateur = serviceUtilisateur.recupererUtilisateur(idUser);
		
		Boolean droitOk = utilisateur.getAccesLivres().stream().anyMatch( acces -> acces.getLivre().getId() == id);
		if(droitOk){
		return repoLivre.findById(id).orElseThrow(() -> new Exception(""));
		}
		
		return null;
	}

	public List<Evenement> recupererAccesEvenement(Long id, Long idUser) throws Exception {
		Livre livre =recupererLivre(id, idUser);
		
		List<Evenement> retour= new ArrayList<Evenement>();
		livre.getEvenements().stream().forEach( evenement ->{
			List<AccesEvenement> accesEvenement =repositoryAccesEvenement.findByUtilisateurAndEvenement(idUser, evenement.getId());
			retour.add(accesEvenement.get(0).getEvenement());
			
		});
		
		return retour;
		
	}


}
