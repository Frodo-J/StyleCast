package com.stylecast.theme.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stylecast.daily.model.service.DailyService;
import com.stylecast.daily.model.vo.Daily;
import com.stylecast.daily.model.vo.Item;
import com.stylecast.theme.model.service.ThemeService;
import com.stylecast.theme.model.vo.Theme;

/**
 * Servlet implementation class ThemeDetailController
 */
@WebServlet("/detail.th")
public class ThemeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemeDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int dno = Integer.parseInt(request.getParameter("dno"));
		int tno = Integer.parseInt(request.getParameter("tno"));
		
		Daily d = new DailyService().selectDailyDetail(dno);
		Theme m = new ThemeService().selectThemeInfo(tno);
		ArrayList<Item> iList = new DailyService().selectDailyItem(dno);
		ArrayList<Daily> dlist = new ThemeService().selectOtherPost(dno, tno);
		
		request.setAttribute("d", d);
		request.setAttribute("m", m);
		request.setAttribute("iList", iList);
		request.setAttribute("dlist", dlist);
		request.getRequestDispatcher("views/trending/trendingDetailView.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
