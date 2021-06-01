package com.stylecast.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stylecast.member.service.MemberService;
import com.stylecast.member.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String memId = request.getParameter("memId");
		String memPwd = request.getParameter("memPwd");
		
		Member loginUser = new MemberService().loginMember(memId, memPwd);
		
		if(loginUser == null) { // 로그인 실패 => 에러페이지 응답
			request.setAttribute("errorMsg", "로그인에 실패하였습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
			
		}else { // 로그인 성공 => mainPage 응답
	
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("alertMsg", "성공적으로 로그인됐습니다!");
			
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
