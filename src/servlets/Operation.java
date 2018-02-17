package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Operation extends Addition {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> pars = request.getParameterMap();
		int result = 0;
		if (pars.containsKey("a") && pars.containsKey("b")) {
			String valueA = request.getParameter("a");
			String valueB = request.getParameter("b");
			if (pars.containsKey("+") || pars.containsKey(" ")) {
				result = Integer.parseInt(valueA) + Integer.parseInt(valueB);
			} else if (pars.containsKey("*")) {
				result = Integer.parseInt(valueA) * Integer.parseInt(valueB);

			} else if (pars.containsKey("/")) {
				result = Integer.parseInt(valueA) / Integer.parseInt(valueB);

			}
		} else {
			result = 0;
		}

		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		out.print(result);
	}

}