package com.stylecast.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stylecast.main.model.service.MainService;
import com.stylecast.main.model.vo.MainSelectCodiM;

/**
 * Servlet implementation class CheckTempController
 */
@WebServlet("/tempCheck.ma")
public class CheckTempController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckTempController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int NowTemp = Integer.parseInt(request.getParameter("Temp"));
		String Weather = request.getParameter("Weather");
		
		ArrayList<MainSelectCodiM> list = new MainService().MainSelectCodiM();
		request.setAttribute("list", list);
		
		System.out.println(NowTemp);
		System.out.println(list);
		
		//System.out.println(NowTemp);
		//System.out.println(Weather);
		
		
		
		
		
		
		//System.out.println(list);
		
		
		request.getRequestDispatcher("views/main/mainPage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
