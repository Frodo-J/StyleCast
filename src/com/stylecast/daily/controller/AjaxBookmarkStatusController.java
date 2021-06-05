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
 * Servlet implementation class AjaxBookmarkStatusController
 */
@WebServlet("/bookmarkYn.do")
public class AjaxBookmarkStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxBookmarkStatusController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		int dailyNo = Integer.parseInt(request.getParameter("dailyNo"));
		
		int likeYn = new DailyService().checkLiked(memNo, dailyNo);
		int bookmarkYn = new DailyService().checkBookmark(memNo, dailyNo);
		
		Daily daily = new Daily();
		daily.setLikeCount(likeYn);
		daily.setBookmarkCount(bookmarkYn);
		
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
