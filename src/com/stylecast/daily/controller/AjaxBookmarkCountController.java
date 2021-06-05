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

/**
 * Servlet implementation class AjaxBookmarkCountController
 */
@WebServlet("/bookmarkCount.do")
public class AjaxBookmarkCountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxBookmarkCountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int memNo = Integer.parseInt(request.getParameter("memNo"));
		int dailyNo = Integer.parseInt(request.getParameter("dailyNo"));
		
		int likeYN = new DailyService().checkLiked(memNo, dailyNo);
		int bookmarkYN = new DailyService().checkBookmark(memNo, dailyNo);
		
		int likeCount = new DailyService().selectLikedCount(dailyNo);
		int bookmarkCount = new DailyService().selectBookmarkCount(dailyNo);
		
		Daily daily = new Daily();
		daily.setLikeCount(likeCount);
		daily.setBookmarkCount(bookmarkCount);
		
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
