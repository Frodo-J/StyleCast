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

/**
 * Servlet implementation class myPageCheck
 */
@WebServlet("/passCheck.me")
public class MypagePassCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypagePassCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String memId = request.getParameter("userId");
		String checkPwd = request.getParameter("checkPwd");
		
		String memPwd = new MemberService().checkMember(memId);
		
		if(memPwd == null) { // 조회 실패
			
			request.setAttribute("errorMsg", "조회에 실패하였습니다");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
			
		}else { // 조회 성공
			if(memPwd.equals(checkPwd)) { // 비밀번호 일치 => 정보 수정 페이지로 이동
				
				response.sendRedirect(request.getContextPath() + "/memberPage.me");
				
			}else { // 비밀번호 불일치 => alert와 함께 passcheck.jsp로 리다이렉트

				HttpSession session = request.getSession();
				session.setAttribute("alertMsg", "비밀번호가 일치하지 않습니다.");
				response.sendRedirect(request.getContextPath() + "/myMember.me");
			}
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
