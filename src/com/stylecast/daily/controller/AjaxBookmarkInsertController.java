package com.stylecast.daily.controller;

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
 * Servlet implementation class BookMarkInsertController
 */
@WebServlet("/bookmark.do")
public class AjaxBookmarkInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxBookmarkInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int memNo = Integer.parseInt(request.getParameter("memNo"));
		int dailyNo = Integer.parseInt(request.getParameter("dailyNo"));
		
		int result = new MemberService().insertBookmark(memNo, dailyNo);
		
		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter().print(result);
		
		/*
		HttpSession session = request.getSession();
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		int memNo = loginUser.getMemNo();
		int dailyNo = Integer.parseInt(request.getParameter("dailyNo"));
		
		int result = new MemberService().insertBookmark(memNo, dailyNo);
		
		if(result > 0) {
			
			String referer = (String)request.getHeader("REFERER");
			response.sendRedirect(referer);
			
		}else { // 에러페이지
		}
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
