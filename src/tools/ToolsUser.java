package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ToolsUser {

	/** Méthodes à faire dans un autre package ? */
	public static String genereCle() {
		int res = 150;
		return String.valueOf(res);
	}

	public static void evacuationConnexion(Integer key) {
		return;
	}

	public static void insertionConnexion(String login) {
		return;
	}

	public static boolean loginExists(String login) {
		if (login == "A") {
			return true;
		} else {
			return false;
		}
	}

	public static boolean userExists(String login, Connection c) {
		boolean res = true;
		try {
		Statement st = c.createStatement();
		String q = "SELECT * FROM Utilisateur WHERE login =" + login + ";";
		ResultSet rs = st.executeQuery(q);
		if(rs.next()) {
			res = true;
		} else {
			res = false;
		}
		st.close();
		rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static boolean checkPassword(String login, String mdp, Connection c) {
		boolean res = true;
		try {
		Statement st = c.createStatement();
		String q = "SELECT * FROM Utilisateur WHERE login =" + login + ";";
		ResultSet rs = st.executeQuery(q);
		if(rs.next()) {
			res = true;
		} else {
			res = false;
		}
		st.close();
		rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
