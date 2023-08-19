package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hit")
public class HitCountApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println();
		ServletContext context = getServletContext();
		Integer count = (Integer)context.getAttribute("HitCount");
		if (count==null) {
			count=1;
		}
		else {
			count++;
		}
		context.setAttribute("HitCount", count);
		out.println("<h1>HitCount Of Application is:: "+count +"</h1>");
	}

}
