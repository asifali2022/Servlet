package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("DispController.class file is loading...");
	}
	public DispController() {
		System.out.println("DispController object is instantiated...");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("DispController Object is initialised with config object data....");
	}	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>OUTPUT</title></head></html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:green;'>CONTEXT PARAMETER INFORMATION</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>CONTEXT PARAMETER NAME</th><th>CONTEXT PARAMETER VALUE</th></tr>");
		ServletContext context = getServletContext();
		Enumeration<String> ParameterNames = context.getInitParameterNames();
		while (ParameterNames.hasMoreElements()) {
			String parameterName = (String) ParameterNames.nextElement();
			String parameterValue = context.getInitParameter(parameterName);
			out.println("<tr>");
			out.println("<td>"+parameterName + "</td>");
			out.println("<td>"+parameterValue + "</td>");
			out.println("</tr>");
			
		}
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
