package in.inueron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("control in servlet 1");
		PrintWriter out = response.getWriter();
		out.println("<center><h1>Welcome to First Servlet</h1></center>");
		RequestDispatcher rd = request.getRequestDispatcher("/servlet2");
		rd.forward(request, response);
		
	}

}
