package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/valid")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("UserName");
		String password = request.getParameter("UserPassword");
		ServletContext sc = request.getServletContext();
		if (name.equalsIgnoreCase("asif")&& password.equalsIgnoreCase("java")) {
			RequestDispatcher rqd = sc.getRequestDispatcher("/home.jsp");
			rqd.forward(request, response);
		} else {
			RequestDispatcher rqd = sc.getRequestDispatcher("/error.jsp");
			rqd.forward(request, response);
		}
	}

}
