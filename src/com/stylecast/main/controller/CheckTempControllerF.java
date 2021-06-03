package com.stylecast.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stylecast.main.model.service.MainService;
import com.stylecast.main.model.vo.MainSelectCodiF;

/**
 * Servlet implementation class CheckTempController
 */
@WebServlet("/tempCheckF.ma")
public class CheckTempControllerF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckTempControllerF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double NowTemp = Double.parseDouble(request.getParameter("Temp"));
		String weather = request.getParameter("Weather");
		
		ArrayList<MainSelectCodiF> listF = new MainService().MainSelectCodiF(NowTemp);
		//request.setAttribute("listC", listC);
		
		System.out.println(NowTemp);
		System.out.println(listF);
		System.out.println(weather);
		
		//System.out.println(NowTemp);
		//System.out.println(Weather);
		
		
		//System.out.println(list);
		
		
		//request.getRequestDispatcher("views/main/mainPage.jsp").forward(request, response);
		
		
		response.setContentType("application/json; charset=utf-8");
		
		
		new Gson().toJson(listF, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
