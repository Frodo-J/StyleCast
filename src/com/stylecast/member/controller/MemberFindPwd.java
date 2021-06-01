package com.stylecast.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stylecast.member.service.MemberService;
import com.stylecast.member.vo.Member;

/**
 * Servlet implementation class MemberFindPwd
 */
@WebServlet("/findPwd.me")
public class MemberFindPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memId = request.getParameter("memId");
		String email = request.getParameter("email");
		
		Member m = new Member(memId, email);
		
		String memPwd = new MemberService().MemberFindPwd(m);

		HttpSession session = request.getSession();
		
		if(memPwd == null) { // 비밀번호 조회 실패시(해당 아이디 또는 이메일이 null일 경우) --> 비밀번호 찾기 페이지 재이동 
			
			session.setAttribute("alertMsg", "해당 아이디 또는 이메일이 없습니다.");
			response.sendRedirect(request.getContextPath() + "/findPwdController.me");
			
		}else { // 성공 ==> alert로 비밀번호 공개
			
			session.setAttribute("alertMsg", "PassWord : " + memPwd);
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
