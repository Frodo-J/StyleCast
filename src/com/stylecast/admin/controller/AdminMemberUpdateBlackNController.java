package com.stylecast.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stylecast.admin.model.service.AdminService;
import com.stylecast.member.vo.Member;

/**
 * Servlet implementation class AdminMemberUpdateBlackNController
 */
@WebServlet("/updateblackn.adm")
public class AdminMemberUpdateBlackNController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberUpdateBlackNController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		if(loginUser != null && loginUser.getAdminYN().equals("Y")) {
			int memNo = Integer.parseInt(request.getParameter("memNo"));
		
			int result = new AdminService().updateMemberBlackN(memNo);
		
				
			if(result > 0) {
				response.sendRedirect("memlist.adm?blackListYN=Y&&currentPage=1");
			}else {
			
			}
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
