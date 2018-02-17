package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class DeleteMessage extends HttpServlet {
	public DeleteMessage() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int key = Integer.parseInt(request.getParameter("key"));
		int idMessage = Integer.parseInt(request.getParameter("idMessage"));

		JSONObject result = new JSONObject();
		result = services.messages.ServiceMessages.deleteMessage(key, idMessage);
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		out.print(result);
	}
}
