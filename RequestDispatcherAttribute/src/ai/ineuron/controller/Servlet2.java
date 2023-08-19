package ai.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("control starts  in servlet 2");
		PrintWriter out = response.getWriter();
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:red;text-align:center;'> ATTRIBUTE INFORMATION</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>attributeName</th><th>attributeValue</th></tr>");
		
		Enumeration<String> attributeNames = request.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			out.println("<tr>");
			String attributeName = attributeNames.nextElement();
			Object attributeV=request.getAttribute(attributeName);
			out.println("<td>" + attributeName  + "</td>");
			out.println("<td>" + attributeV + "</td>");
			out.print("</tr>");
		}
		
		
		out.println("</body>");
		out.println("</center>");
		out.println("</table>");
		out.close();
		System.out.println("control ends  in servlet 2");
	}
	

	

	
}
