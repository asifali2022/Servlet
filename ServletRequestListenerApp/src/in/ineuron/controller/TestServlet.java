package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    static
    {
    	System.out.println("TestServlet.class file is loading...");
    }
    public TestServlet() {
    	System.out.println("TestServlet Object is instantiated...");  
    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("TestServlet object is initialized...");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1>This is RequestListener TestServlet</h1>");
		out.println("<h1>The number of hit for this application is :: " /*+ RequestDemoListener.count +*/+"</h1>");
		System.in.read();
		out.close();
	}

	
	

}
