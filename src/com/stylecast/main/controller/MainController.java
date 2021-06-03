package com.stylecast.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD:src/com/stylecast/member/controller/TermsOfUse.java

/**
 * Servlet implementation class TermsOfUse
 */
@WebServlet("/termsofUse.po")
public class TermsOfUse extends HttpServlet {
=======

import com.stylecast.main.model.service.MainService;
import com.stylecast.main.model.vo.MainSelectDaily;


/**
 * Servlet implementation class MainController
 */
@WebServlet("")
public class MainController extends HttpServlet {
>>>>>>> feature/main_page:src/com/stylecast/main/controller/MainController.java
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
<<<<<<< HEAD:src/com/stylecast/member/controller/TermsOfUse.java
    public TermsOfUse() {
=======
    public MainController() {
>>>>>>> feature/main_page:src/com/stylecast/main/controller/MainController.java
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD:src/com/stylecast/member/controller/TermsOfUse.java

		request.getRequestDispatcher("views/member/termsOfUse.jsp").forward(request, response);
	
=======
		
		ArrayList<MainSelectDaily> list = new MainService().MainSelectDaily();
		
		//System.out.println(list);
		
		request.setAttribute("list", list);
		
		//System.out.println(list);
		
		
		
		request.getRequestDispatcher("views/main/mainPage.jsp").forward(request, response);
		
>>>>>>> feature/main_page:src/com/stylecast/main/controller/MainController.java
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
