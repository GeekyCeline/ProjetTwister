package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class CreationUtilisateur extends HttpServlet {

	public CreationUtilisateur() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");

		JSONObject result = new JSONObject();
		result = services.users.ServiceUser.creationUtilisateur(login, mdp, pseudo,
				nom, prenom, email);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		out.print(result);
	}
}
