package utils.params;

public abstract class RequestParamUtils {

	public static Integer getNiveauInferieur(Integer niveauInferieur) {
		if (null == niveauInferieur) {
			niveauInferieur = 99;
		}
		return niveauInferieur;
	}

}
