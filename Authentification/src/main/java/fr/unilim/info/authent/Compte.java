package fr.unilim.info.authent;

/**
 * Compte utilisateur permettant d'acceder au systeme
 *
 */
public class Compte {

	/**
	 * Identifiant du compte utilisateur
	 */
	protected String identifiant;

	/**
	 * Le compte est actif (ou non)
	 */
	protected boolean actif;

	/**
	 * Constructeur avec arguments
	 * @param identifiant
	 * @param motDePasse
	 */
	public Compte(String identifiant) {
		this.identifiant = identifiant;
		this.actif = true;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	/**
	 * Implémentation du hashCode
	 * 
	 * @return la valeur du hashCode de l'objet
	 */
	public int hashCode() {
		// On choisit deux nombres impairs
		final int multiplieur = 17;
		int result = 7;

		// Pour chaque attribut, on calcule le hashcode
	    // que l'on ajoute au resultat
		// apres l'avoir multiplié par le nombre "multiplieur"
		result = (multiplieur * result) + identifiant.hashCode();
		return result;
	}

	/**
	 * Implémentation du equals : on va comparer les identifiants de chaque compte
	 * 
	 * @param obj l'objet à comparer avec l'instance courante pour déterminer s'ils sont égaux
	 * 
	 * @return true si les deux objets sont égaux, false sinon
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		if (identifiant != other.identifiant)
			return false;
		return true;
	}

	/**
	 * Surcharge de la methode toString pour personnaliser l'affichage
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id=[").append(this.identifiant)
		  .append("],actif=[").append(this.actif).append("]");
		return sb.toString();
	}

}
