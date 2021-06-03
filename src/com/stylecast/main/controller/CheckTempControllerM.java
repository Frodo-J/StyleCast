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
import com.stylecast.main.model.vo.MainSelectCodiMR;

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
		
		if(weather.equals("rain") || weather.equals("snow")) {
			ArrayList<MainSelectCodiMR> listC = new MainService().MainSelectCodiMR(NowTemp);
			response.setContentType("application/json; charset=utf-8");
			new Gson().toJson(listC, response.getWriter());
		}else {
			ArrayList<MainSelectCodiM> listC = new MainService().MainSelectCodiM(NowTemp);
			response.setContentType("application/json; charset=utf-8");
			new Gson().toJson(listC, response.getWriter());
		}
		//request.setAttribute("listC", listC);
		
//		System.out.println(NowTemp);
//		System.out.println(listC);
//		System.out.println(weather);
		
		//System.out.println(NowTemp);
		//System.out.println(Weather);
		
		
		//System.out.println(list);
		
		
		//request.getRequestDispatcher("views/main/mainPage.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
