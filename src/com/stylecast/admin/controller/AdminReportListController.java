package com.stylecast.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stylecast.admin.model.service.AdminService;
import com.stylecast.daily.model.vo.Report;
import com.stylecast.member.vo.Member;

/**
 * Servlet implementation class AdminReportListController
 */
@WebServlet("/rptList.adm")
public class AdminReportListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReportListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		// 관리자 여부 확인
		if(loginUser != null && loginUser.getAdminYN().equals("Y")) {
			
			int brCategory = Integer.parseInt(request.getParameter("brCategory"));
			
			ArrayList<Report> list = new AdminService().selectReportList(brCategory);

			request.setAttribute("brCategory", brCategory);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/admin/adminReportList.jsp").forward(request,response);
			
		}else {
			session.setAttribute("alertMsg", "관리자만 접근 가능한 페이지입니다.");
			response.sendRedirect(request.getContextPath());
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
