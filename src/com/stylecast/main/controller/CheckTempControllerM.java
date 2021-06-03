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
import com.stylecast.main.model.vo.MainSelectCodiM;

/**
 * Servlet implementation class CheckTempController
 */
@WebServlet("/tempCheckM.ma")
public class CheckTempControllerM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckTempControllerM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double NowTemp = Double.parseDouble(request.getParameter("Temp"));
		String weather = request.getParameter("Weather");
		
		ArrayList<MainSelectCodiM> listC = new MainService().MainSelectCodiM(NowTemp);
		//request.setAttribute("listC", listC);
		
		System.out.println(NowTemp);
		System.out.println(listC);
		System.out.println(weather);
		
		//System.out.println(NowTemp);
		//System.out.println(Weather);
		
		
		//System.out.println(list);
		
		
		//request.getRequestDispatcher("views/main/mainPage.jsp").forward(request, response);
		
		
		response.setContentType("application/json; charset=utf-8");
		
		
		new Gson().toJson(listC, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
