package com.stylecast.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CodiSearchController
 */
@WebServlet("/searchCodi.ad")
public class CodiSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodiSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gender = request.getParameter("gender");
		String weather = request.getParameter("weather");
		
		if(gender.equals("ALL") && weather.equals("ALL")) {
			
		}else if(gender.equals("ALL") && (weather.equals("CLEAR")) || weather.equals("RAIN")) {
			
		}else if((gender.equals("M") || gender.equals("F")) && weather.equals("ALL")) {
			
		}else {
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
