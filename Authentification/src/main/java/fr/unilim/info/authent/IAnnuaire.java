package fr.unilim.info.authent;


public interface IAnnuaire {

	/**
	 * Crée un nouvel utilisateur dans l'annuaire
	 * @param identifiant l'identifiant du compte utilisateur
	 * @param motDePasse le mot de passe a verifier
	 * @param id l'utilisateur a creer dans le systeme
	 * @return <code>true</code> si le compte a été créé avec succès, ou <code>false</code> sinon
	 */
	boolean creerCompte(String identifiant, String motDePasse);

	/**
	 * Supprime un compte dans l'annuaire
	 * @param identifiant l'identifiant du compte utilisateur
	 * @return <code>true</code> si le compte a été supprimé avec succès, ou <code>false</code> sinon
	 */
	boolean supprimerCompte(String identifiant);

	/**
	 * Verifie si le mot de passe est correct
	 * @param identifiant l'identifiant du compte utilisateur
	 * @param motDePasse le mot de passe a verifier
	 * @return <code>true</code> si le mot de passe est correct, <code>false</code> sinon
	 */
	boolean verifierMotDePasse(String identifiant, String motDePasse);

	/**
	 * Recupere un compte utilisateur a partir de son identifiant
	 * 
	 * @param identifiant identifiant de l'utilisateur recherche
	 * @return le compte utilisateur recherché s'il est trouvé, null sinon
	 */
	Compte recupererCompteParIdentifiant(String identifiant);

}
