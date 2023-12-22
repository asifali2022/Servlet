package in.ineuron.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import in.ineuron.customizedRequest.CustomizedRequest;



@WebFilter("/test")
public class AlterWordFilter  implements Filter {

	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hreq=(HttpServletRequest)request;
		CustomizedRequest creq=new CustomizedRequest(hreq);
		System.out.println("before filter");
		chain.doFilter(creq, response);
		System.out.println("after filter");
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
