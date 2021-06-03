package com.stylecast.daily.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stylecast.daily.model.service.DailyService;
import com.stylecast.daily.model.vo.Daily;
import com.stylecast.member.service.MemberService;

/**
 * Servlet implementation class AjaxBookmarkMultiController
 */
@WebServlet("/bookmarkMulti.do")
public class AjaxBookmarkMultiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxBookmarkMultiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		int dailyNo = Integer.parseInt(request.getParameter("dailyNo"));
		int bookmarkYn = new DailyService().checkBookmark(memNo, dailyNo);
		
		int result = 0;
		
		if(bookmarkYn > 0) { // 북마크 등록 상태 => 북마크 삭제
			
			result = new MemberService().deleteBookmark(memNo, dailyNo);
			
		}else { //  북마크 등록
			
			result = new MemberService().insertBookmark(memNo, dailyNo);
		}
		
		// 등록/삭제 처리 후 북마크수 조회
		int bookmarkCount = new DailyService().selectBookmarkCount(dailyNo);
		
		// 등록/삭제 처리 후 북마크 여부 다시 조회
		bookmarkYn = new DailyService().checkBookmark(memNo, dailyNo);
		
		Daily daily = new Daily();
		daily.setBookmarkCount(bookmarkCount);
		daily.setLikeCount(bookmarkYn); // 좋아요수에 북마크여부 임시로 담음 ( 1=북마크o / 0=북마크x )
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(daily, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
