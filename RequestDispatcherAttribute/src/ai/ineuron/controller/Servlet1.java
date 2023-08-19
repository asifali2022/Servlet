package ai.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("control in servlet 1");
//		request.setAttribute("asif","java");
//		request.setAttribute("lopez","javaScript");
//		request.setAttribute("astech","python");
		
		
		RequestDispatcher rqd = request.getRequestDispatcher("/servlet2");
		rqd.forward(request, response);
		System.out.println("control ends in servlet 1");
	}	

}
