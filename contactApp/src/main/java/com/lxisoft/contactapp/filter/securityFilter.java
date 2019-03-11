package com.lxisoft.contactapp.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * Servlet Filter implementation class RequestLoggingFilter
 */
public class SecurityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }

   
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		 PrintWriter out = response.getWriter();
		 RequestDispatcher rd=null;
	     String password = request.getParameter("password");
	     String username = request.getParameter("username");
	       // System.out.println("Password Is?= " + password);
	 if(username !=null && username.equals("admin")){
	        if(password != null && password.equals("admin123")) {
	            /***** Send Request To Next Resource *****/ 
	        	// pass the request along the filter chain
	            chain.doFilter(request, response);
	        	} 
	        }else { 
	        	out.println("<p id='errMsg' style='color: red; font-size: larger;'>User Name or PassWord Incorrect!!!</p>");
	            rd = request.getRequestDispatcher("/Error.jsp");  
	            rd.include(request, response);  
	        }
	}

	 /**
		 * @see Filter#init(FilterConfig)
		 */
		
	    public void init(FilterConfig fConfig) throws ServletException {
			// TODO Auto-generated method stub
		}

}
