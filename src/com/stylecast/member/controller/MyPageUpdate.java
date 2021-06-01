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
 * Servlet implementation class MyPageUpdate
 */
@WebServlet("/update.me")
public class MyPageUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String userPwd = (request.getParameter("userNewPwd") == "") ? request.getParameter("userPwd") : request.getParameter("userNewPwd");
		
		Member m = new Member(userId, userPwd, userName, email, gender);
		
		// 수정한 회원의 정보
		Member updateMem = new MemberService().updateMember(m);
		
		if(updateMem == null) { // 정보 수정 실패
			
			request.setAttribute("errorMsg", "회원 정보 수정에 실패했습니다.");
			request.getRequestDispatcher("view/common/errorPage.jsp").forward(request, response);;
		
		}else { // 정보 수정 성공
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateMem);
			session.setAttribute("alertMsg", "성공적으로 회원 정보를 수정했습니다.");
			
			response.sendRedirect(request.getContextPath() + "/myPage.me");
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
