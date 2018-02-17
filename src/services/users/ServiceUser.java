package services.users;

import java.sql.Connection;

import org.json.JSONException;
import org.json.JSONObject;

import ErrorJSON.ErreursJSON;
import bd.Database;

public class ServiceUser {

	public static Connection c = Database.getMySQLConnection();

	/***
	 * Création d'un utilisateur
	 * 
	 * @param login
	 *            id sous lequel l'utilisateur va s'identifier
	 * @param mdp
	 *            mot de passe
	 * @param pseudo
	 *            nom affiché
	 * @param nom
	 * @param prenom
	 * @param email
	 * @return JSONObject avec code erreur et message descriptif
	 */
	public static JSONObject creationUtilisateur(String login, String mdp,
			String pseudo, String nom, String prenom, String email) {
		JSONObject o = new JSONObject();
		try {
			if ((login == null) || (mdp == null) || (pseudo == null)
					|| (nom == null) || (prenom == null) || (email == null)) {
				o = ErreursJSON
						.serviceRefused("Parametre(s) invalide(s)", "-1");
				return o;
			} else {
				if (!tools.ToolsUser.loginExists(login)) {
					o = ErreursJSON.serviceAccepted("OK", "1");
					insertionBDComptes(login, mdp, pseudo, nom, prenom, email);
				} else {
					o = ErreursJSON
							.serviceRefused("Le login existe déjà", "-1");
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return o;
	}

	/***
	 * Méthode de connexion à un compte présent dans la BD
	 * 
	 * @param login
	 *            id du compte
	 * @param mdp
	 *            mot de passe du compte
	 * @return JSONObject avec code erreur et message descriptif
	 */
	public static JSONObject login(String login, String mdp) {
		JSONObject o = new JSONObject();
		try {
			if (login == null || mdp == null) {
				o = ErreursJSON
						.serviceRefused("Parametre(s) invalide(s)", "-1");
			} else {
				if (!tools.ToolsUser.userExists(login, c)) {
					o = ErreursJSON.serviceRefused("Ce login n'existe pas",
							"-1");
				} else {
					if (!mdpCorrect(login, mdp)) {
						o = ErreursJSON.serviceRefused(
								"Mot de passe incorrect", "-2");
					} else {
						if (userNonConnecte(login)) {
							tools.ToolsUser.insertionConnexion(login);
							o = ErreursJSON.serviceAccepted("OK", "key :"
									+ tools.ToolsUser.genereCle());
						} else {
							o = ErreursJSON
									.serviceRefused(
											"Veuillez vous déconnecter de votre autre appareil",
											"-3");
						}
					}
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return o;
	}

	public static JSONObject logout(Integer key) {
		JSONObject o = new JSONObject();
		if (key == null) {
			o = ErreursJSON.serviceRefused("Parametre(s) invalide(s)", "-1");
		} else {
			tools.ToolsUser.evacuationConnexion(key);
			try {
				o = ErreursJSON.serviceAccepted("Vous êtes déconnecté", "1");
			} catch (JSONException e) {
				o = ErreursJSON.serviceRefused("Restez connecté(e)", "100");
			}
		}
		return o;
	}

	/**
	 * 
	 * 
	 * Ci-dessous les méthodes à réellement coder
	 * 
	 * 
	 */

	public static void insertionBDComptes(String login, String mdp,
			String pseudo, String nom, String prenom, String email) {
	}

	public static boolean mdpCorrect(String login, String mdp) {
		if (mdp == "mdpDe" && (login instanceof String)) {
			return true;
		}
		return false;
	}

	public static boolean userNonConnecte(String login) {
		if (login != "Non connecté") {
			return true;
		}
		return false;
	}
}