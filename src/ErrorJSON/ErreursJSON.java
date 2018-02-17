package ErrorJSON;

import org.json.JSONException;
import org.json.JSONObject;

public class ErreursJSON {

	public static JSONObject serviceRefused(String message, String codeError) {
		JSONObject o = new JSONObject();
		try {
			o.put("Message", message);
			o.put("Code erreur", codeError);
		} catch (JSONException e) {
			e.printStackTrace();

		}
		return o;
	}

	public static JSONObject serviceAccepted(String message, String codeError)
			throws JSONException {
		JSONObject o = new JSONObject();
		o.put("Message", message);
		o.put("Code erreur", codeError);
		return o;
	}
}
