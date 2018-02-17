package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class Login extends HttpServlet {

	public Login() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");

		JSONObject result = new JSONObject();
		result = services.users.ServiceUser.login(login, mdp);
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		out.print(result);
	}
}