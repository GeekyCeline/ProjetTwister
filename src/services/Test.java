package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONObject;

import bd.Database;

public class Test {

	public static void main(String[] args) {
		JSONObject o;
		String login = "B";
		String victime = "A";

//		 Operation o = new Operation(5, 3, "*");
//		 System.out.println(o.toString());
//		 o = ServiceUser.creationUtilisateur("HarryP", "MdP", "HPotter",
//		 "Potter",
//		 "Harry", "gryffondor@poudlard.gb");
//		 System.out.println("Fin main " + o.toString());
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection co = Database.getMySQLConnection();
		String query = "SELECT * FROM Utilisateur";
		Statement st = co.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			for (int i = 1; i < 6; i++) {
				System.out.println(rs.getString(i));
			}
		}
		st.close();
		co.close();
		} catch (Exception e) {
			System.out.println("EXCEPTION");
		}
		System.out.println("FIN MAIN");
		
//		o = ServiceUser.login("A", "mdpDe");
//		System.out.println(o.toString());
		
//		String l = null;
//		o = ServiceUser.logout(l);
//		System.out.println(o.toString());
		
//		o = ServiceVictimes.ajouterSuiveur(login, victime);
//		System.out.println(o.toString());
//		o = ServiceVictimes.afficherFollowers(login);
//		System.out.println(o.toString());
//		o = ServiceVictimes.effacerVictime(login, victime);
//		System.out.println(o.toString());
		
	}
}
