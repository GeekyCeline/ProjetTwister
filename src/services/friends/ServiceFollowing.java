package services.friends;

import org.json.JSONException;
import org.json.JSONObject;

import ErrorJSON.ErreursJSON;

public class ServiceFollowing {
	public static JSONObject ajouterFollowing(Integer key, String following) {
		JSONObject o = new JSONObject();
		if (key == null || following == null) {
			o = ErreursJSON.serviceRefused("Parametre(s) invalide(s)", "-1");
		} else {
			if (!tools.ToolsUser.loginExists(following)) {
				o = ErreursJSON.serviceRefused("La personne que vous voulez suivre n'existe pas",
						"-1");
			} else {
				if (tools.ToolsFollowing.dejaSuivi(key, following)) {
					o = ErreursJSON.serviceRefused(
							"Vous suivez déjà cette personne", "-1");
				} else {
					tools.ToolsFollowing.insertionFollowing(key, following);
					try {
						o = ErreursJSON.serviceAccepted(
								"Vous suivez à présent " + following, "1");
					} catch (JSONException e) {
						o = ErreursJSON.serviceRefused("Bug", "100");
					}
				}
			}
		}
		return o;
	}

	public static JSONObject afficherFollowings(Integer key) {
		JSONObject o = new JSONObject();
		if (key == null) {
			o = ErreursJSON.serviceRefused("Parametre(s) invalide(s)", "-1");
		} else {
			tools.ToolsFollowing.afficherFollowings(key);
			try {
				o = ErreursJSON.serviceAccepted("Voici les personnes que vous suivez cher "
						+ key, "1");
			} catch (JSONException e) {
				o = ErreursJSON.serviceRefused("Bug", "100");
			}
		}
		return o;
	}

	public static JSONObject removeFollowing(Integer key, String following) {
		JSONObject o = new JSONObject();
		if (key == null || following == null) {
			o = ErreursJSON.serviceRefused("Parametre(s) invalide(s)", "-1");
		} else {
			if (!tools.ToolsUser.loginExists(following)) {
				o = ErreursJSON.serviceRefused(following + " n'existe pas", "-1");
			} else {
				if (!tools.ToolsFollowing.dejaSuivi(key, following)) {
					o = ErreursJSON.serviceRefused("Vous ne suivez pas "
							+ following, "-1");
				} else {
					tools.ToolsFollowing.removeFollowing(key, following);
					try {
						o = ErreursJSON.serviceAccepted(following
								+ " n'est plus dans la liste des personnnes que vous suivez", "1");
					} catch (JSONException e) {
						o = ErreursJSON.serviceRefused("Bug", "100");
					}
				}
			}
		}
		return o;
	}

}
