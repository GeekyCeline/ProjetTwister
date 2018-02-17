package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Database {
	private DataSource dataSource;

	public Database(String jndiname) throws SQLException {
		try {
			dataSource = (DataSource) new InitialContext()
					.lookup("java:comp/env/" + jndiname);
		} catch (NamingException e) {
			// Handle error that it’s not configured in JNDI.
			throw new SQLException(jndiname + " manque dans JNDI : "
					+ e.getMessage());
		}
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public static Connection getMySQLConnection() throws SQLException {
		Database database = null;
		if (DBStatic.mysql_pooling == false) {
			return (DriverManager.getConnection("jdbc:mysql://" + DBStatic.host
					+ "/" + DBStatic.baseDeDonnees, DBStatic.nomUtilisateur,
					DBStatic.mdp));
		} else {
			if (database == null) {
				database = new Database("jdbc/db");
			}
			return (database.getConnection());
		}
	}
}
