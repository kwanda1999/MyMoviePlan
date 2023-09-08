package com.mongo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/loginServlet")

public class Login {
	
	private static final long serialVersionUID = 1L;
	
	 public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		 
	
	        String param1 = req.getParameter("adminemail"), 
	                param2 = req.getParameter("adminpass");
	 

	        if(param1 == null || param2 == null || "".equals(param1) || "".equals(param2)) {
	            req.setAttribute("error_message", "Please enter admin email and password");
	            req.getRequestDispatcher("/adminLogin.html").forward(req, resp);
	        } else {
	            boolean isUserFound = Util.searchUserInDb(param1, param2);
	            if(isUserFound) {               
	                req.getRequestDispatcher("/adminportal.html").forward(req, resp);
	            } else {
	                req.setAttribute("error_message", "You are not an authorised user. Please check with administrator.");
	                req.getRequestDispatcher("/adminLogin.jsp").forward(req, resp);
	            }   
	        }       
	    }
	}




