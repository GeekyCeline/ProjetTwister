package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Addition extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Map <String,String[]> pars=request.getParameterMap();
		int sum;
		if(pars.containsKey("a") && pars.containsKey("b")){
			String valueA=request.getParameter("a");
			String valueB=request.getParameter("b");
			sum=Integer.parseInt(valueA)+Integer.parseInt(valueB);

		}
		else {sum=0;}

		PrintWriter out=response.getWriter();
		response.setContentType("text/plain");
		out.print(sum);
	}

}