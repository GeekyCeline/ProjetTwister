package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class Logout extends HttpServlet {

	public Logout() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int key = Integer.parseInt(request.getParameter("key"));

		JSONObject result = new JSONObject();
		result = services.users.ServiceUser.logout(key);
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		out.print(result);
	}
}
