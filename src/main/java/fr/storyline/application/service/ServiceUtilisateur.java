package fr.storyline.application.service;

import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.swing.JWindow;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import antlr.StringUtils;
import fr.pereirafrederic.v2.storyline.controller.dto.InscriptionDto;
import fr.pereirafrederic.v2.storyline.exception.BusinessException;
import fr.pereirafrederic.v2.storyline.exception.TechnicalException;
import fr.storyline.application.entity.contenu.Livre;
import fr.storyline.application.entity.user.Utilisateur;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class ServiceUtilisateur implements InitializingBean {
	
	@Autowired
	private RepositoryUtilisateur repositoryUtilisateur;
	
	@Value("${base64JWTSecretkey}")
	private String base64JWTSecretkey;
	private SecureRandom secureRandom;
	private static final SignatureAlgorithm JWT_SECRET_ALGO = SignatureAlgorithm.RS512;
	private PrivateKey jwtSecretkey;

	public Utilisateur recupererUtilisateur(Long id) {
		Optional<Utilisateur> utilisateur = repositoryUtilisateur.findById(id);
		
		return utilisateur.get();
	}

	public List<Livre> recupererLivres(Long id) {

		Utilisateur utilisateur =recupererUtilisateur(id);
		
		List<Livre> retour =new ArrayList<Livre>();
		utilisateur.getAccesLivres().stream().forEach(acces -> retour.add(acces.getLivre()));
		return retour;
	}

	public Utilisateur inscription(InscriptionDto inscription) {
		
		
	List<Utilisateur> pseudotrouves = repositoryUtilisateur.findByPseudo(inscription.getPseudo() );
	List<Utilisateur> emailtrouves = repositoryUtilisateur.findByEmail( inscription.getEmail());
	
	if(!pseudotrouves.isEmpty()) {
		throw new BusinessException("ce pseudo est déjà pris", null);
	}
	if(!emailtrouves.isEmpty()) {
		throw new BusinessException("ce pseudo est déjà pris", null);
	}
	
	if( !inscription.getPasswordOne().equalsIgnoreCase(inscription.getPasswordTwo())) {
		throw new BusinessException("les 2 mots de passe doivent être identique", null);
	}
	
	Utilisateur user= new Utilisateur();
	user.setPseudo(inscription.getPseudo());
	user.setEmail(inscription.getEmail());
	
	
	String salt = generateSalt();
	String passWordhash = encodePassword(inscription.getPasswordOne(), salt);
	
	user.setMotDePasse(passWordhash);
	
	Utilisateur userRetour = repositoryUtilisateur.save(user);
		return userRetour;
	}
	
	private String generateSalt() {
		byte[] saltValue = new byte[16];
				secureRandom.nextBytes(saltValue);
		
		saltValue[15] = 0x02;
		
		return new String(Base64.getEncoder().encode(saltValue));
	}

	private String encodePassword(String pass, String salt) {
		try {
			MessageDigest digest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
			return new String(Base64.getEncoder().encode((digest.digest((pass + salt).getBytes()))));
		}catch (NoSuchAlgorithmException e) {
			throw new TechnicalException(e);
		}
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		if(org.springframework.util.StringUtils.isEmpty(base64JWTSecretkey)){
			KeyFactory kf = KeyFactory.getInstance(JWT_SECRET_ALGO.getFamilyName());
				jwtSecretkey = kf.generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64JWTSecretkey)));
		}
		secureRandom= SecureRandom.getInstance("SHA1PRNG", "SUN");
		
	}


}
