package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/demo")
public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
	  LocalDateTime date = LocalDateTime.now();
	  int hour = date.getHour();
	  String msg="";
	  if(hour<12)
	  {
		  msg+="Good Morning";
		  
	  }
	  else if(hour<16)
	  {
		  msg+="Good Afternoon";  
		 
	  }
	  else if(hour<20)
	  {
		  msg+="Good Evening";  
		 
	  }
	  else 
	  {
		  msg+="Good Night";  
		 
	  }
		
	  out.println("<h1 style='color:red;text-align:center;'>Welcome To Serverlet Coding</h1>");
	  out.println("<h1 style='color:red;text-align:center;'>The Current Date And Time Is::" + date + "</h1>");
	  out.println("<h1 style='color:red;text-align:center;'>Greetings From The Server::" + msg + "</h1>");
	  
	  out.println("</br> Servlet Request  Object Address Is::"+request.hashCode());
	  out.println("</br> Servlet Response Object Address Is::"+response.hashCode());
	  out.println("</br> Current Servlet  Object Address Is::"+this.hashCode());
	  out.println("</br> Servlet Request-Thread  Object Addresse Is::"+Thread.currentThread().hashCode());
	  
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
