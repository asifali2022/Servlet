package com.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");
		String sgen = request.getParameter("sgen");
		String saddr = request.getParameter("saddr");
		String smarks = request.getParameter("smarks");
		String sbranch = request.getParameter("sbranch");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>FOURTHPAGE</title></head>");
		out.println("<body bgcolor='pink'>");
		out.println("<center>");
		out.println("<h1 style='color: red;'>Student Details</h1>");
		out.println("<table border='2'>");
		out.println("<tr><td>sname</td><td>"+sname+"</td></tr>");
		out.println("<tr><td>sage</td><td>"+sage+"</td></tr>");
		out.println("<tr><td>sgen</td><td>"+sgen+"</td></tr>");
		out.println("<tr><td>saddr</td><td>"+saddr+"</td></tr>");
		out.println("<tr><td>smarks</td><td>"+smarks+"</td></tr>");
		out.println("<tr><td>sbranch</td><td>"+sbranch+"</td></tr>");

		out.println("</table>");
		
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
