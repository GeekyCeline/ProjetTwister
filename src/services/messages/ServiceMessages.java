package services.messages;

import org.json.JSONException;
import org.json.JSONObject;

import ErrorJSON.ErreursJSON;

public class ServiceMessages {
	public static JSONObject newMessage(Integer key, String message) {
		JSONObject o = new JSONObject();
		if (key == null || message == null) {
			o = ErreursJSON.serviceRefused("Paramètre(s) invalide(s)", "-1");
		} else {
			if (message == "") {
				o = ErreursJSON.serviceRefused("Le message est vide", "-1");
			} else {
				tools.ToolsMessage.ajouterMessageBD(key, message);
				try {
					o = ErreursJSON.serviceAccepted(
							"Votre message a été posté", "1");
				} catch (JSONException e) {
					o = ErreursJSON.serviceRefused("Bug", "100");
				}
			}
		}
		return o;
	}

	public static JSONObject deleteMessage(Integer key, Integer idMessage) {
		JSONObject o = new JSONObject();
		if (key == null || idMessage == null) {
			o = ErreursJSON.serviceRefused("Paramètre(s) invalide(s)", "-1");
		} else {
			if (!tools.ToolsMessage.messageExists(idMessage)) {
				o = ErreursJSON.serviceRefused("Le message est n'existe pas",
						"-1");
			} else {
				tools.ToolsMessage.retirerMessageBD(key, idMessage);
				try {
					o = ErreursJSON.serviceAccepted(
							"Votre message a été supprimé", "1");
				} catch (JSONException e) {
					o = ErreursJSON.serviceRefused("Bug", "100");
				}
			}
		}
		return o;
	}
}
