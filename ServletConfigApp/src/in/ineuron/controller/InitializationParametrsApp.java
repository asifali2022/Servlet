package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InitializationParametrsApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<center><h1> Initialization Parameters</center><h1><hr/>");
		out.println("<table border='1' Align='center'>");
		out.println("<tr><th>Parameter Name</th><th>Paramter Value</th></tr>");
		Enumeration<String> ParameterNames = getInitParameterNames();
		while (ParameterNames.hasMoreElements()) {
			String ParameterName = (String)ParameterNames.nextElement();
			String value = getInitParameter(ParameterName);
			out.println("<tr><td>"+ ParameterName + "</td><td>" + value + "</td></tr>");
			
		}
		out.println("</table");
		out.close();
		
	}

	

}
