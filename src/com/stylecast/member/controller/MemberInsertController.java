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
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String memId = request.getParameter("memId"); // "아이디"
		String email = request.getParameter("email"); // "이메일"
		String memPwd = request.getParameter("memPwd"); // "비밀번호"
		String memName = request.getParameter("memName"); // "닉네임"
		String[] genderArr = request.getParameterValues("gender"); // "성별"
	
		// String[]		-->		String
		// ["F", "M"]	-->	  "F, M"
		String gender = "";
		if(genderArr != null) {
			gender = String.join(",", genderArr);
		}
		
		Member m = new Member(memId, email, memPwd, memName, gender);
		
		int result = new MemberService().insertMember(m);
		
		if(result > 0) {
			
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원가입되었습니다.");
			
			response.sendRedirect(request.getContextPath());
			
		}else { 
			
			request.setAttribute("errorMsg", "회원가입에 실패했습니다!");
			
			RequestDispatcher view  = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
			
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
