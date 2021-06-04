package com.stylecast.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stylecast.admin.model.service.AdminService;
import com.stylecast.daily.model.vo.Report;

/**
 * Servlet implementation class AdminReportSearchController
 */
@WebServlet("/rptSearch.adm")
public class AdminReportSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReportSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String category = request.getParameter("searchCategory");
		String text = request.getParameter("searchText");
		int brCategory = Integer.parseInt(request.getParameter("boardCategory"));
		
		ArrayList<Report> list = new AdminService().selectSearchReportList(category, text, brCategory);

		request.setAttribute("brCategory", brCategory);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/admin/adminReportSearchList.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
