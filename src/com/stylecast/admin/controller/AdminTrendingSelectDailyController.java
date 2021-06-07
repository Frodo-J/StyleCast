package com.stylecast.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stylecast.admin.model.service.AdminService;
import com.stylecast.daily.model.vo.Daily;

/**
 * Servlet implementation class AdminTrendingSelectDailyController
 */
@WebServlet("/selectTPost.tr")
public class AdminTrendingSelectDailyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTrendingSelectDailyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int tno = Integer.parseInt(request.getParameter("tno"));

		ArrayList<Daily> dlist = new AdminService().selectDailyList(tno);
		System.out.println(tno);
		
		request.setAttribute("tno", tno);
		request.setAttribute("dlist", dlist);
		request.getRequestDispatcher("views/admin/adminTrendingSelectView.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
