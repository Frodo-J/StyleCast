package com.stylecast.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stylecast.admin.model.service.AdminService;

/**
 * Servlet implementation class AdminMemberUpdateBlackController
 */
@WebServlet("/updateblacky.adm")
public class AdminMemberUpdateBlackYController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberUpdateBlackYController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
		int result = new AdminService().updateMemberBlackY(memNo);
		
				
		if(result > 0) {
			response.sendRedirect("memlist.adm?blackListYN=N&&currentPage=1");
		}else {
			
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
