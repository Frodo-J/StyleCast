package com.stylecast.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stylecast.member.service.MemberService;

/**
 * Servlet implementation class FindId
 */
@WebServlet("/findId.me")
public class MemberFindId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");

		String memId = new MemberService().MemberFindId(email);
		
		HttpSession session = request.getSession();
		
		if(memId == null) { // 아이디 조회 실패시 --> 아이디 찾기 페이지 재이동
			
			session.setAttribute("alertMsg", "해당 이메일의 아이디는 없습니다. 이메일 주소를 확인하세요.");
			response.sendRedirect(request.getContextPath() + "/findIdController.me");
		
		}else { // 성공 --> alert로 아이디 공개
			
			session.setAttribute("alertMsg", "ID : " + memId);
			response.sendRedirect(request.getContextPath() + "/loginPage.me");
			
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
