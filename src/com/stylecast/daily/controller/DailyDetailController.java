package com.stylecast.daily.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stylecast.daily.model.service.DailyService;
import com.stylecast.daily.model.vo.Daily;
import com.stylecast.daily.model.vo.DailyCM;
import com.stylecast.daily.model.vo.Item;
import com.stylecast.member.vo.Member;

/**
 * Servlet implementation class DailyDetailController
 */
@WebServlet("/detail.da")
public class DailyDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DailyDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		int dailyNo = Integer.parseInt(request.getParameter("dno"));
	
		Daily d = new DailyService().selectDailyDetail(dailyNo);
		ArrayList<Item> iList = new DailyService().selectDailyItem(dailyNo);
<<<<<<<< HEAD:src/com/stylecast/daily/controller/DailyDetailController.java
			
		request.setAttribute("d", d);
		request.setAttribute("iList", iList);
========
		ArrayList<DailyCM> cList = new DailyService().selectDailyCM(dailyNo);
		
		int likeYN = 0;
		int bookmarkYN = 0;
		
		int likeCount = new DailyService().selectLikedCount(dailyNo);
		int bookmarkCount = new DailyService().selectBookmarkCount(dailyNo);
		
		if(loginUser != null) {
			
			int memNo = loginUser.getMemNo();
			
			likeYN = new DailyService().checkLiked(memNo, dailyNo);
			bookmarkYN = new DailyService().checkBookmark(memNo, dailyNo);
		}
			
		request.setAttribute("d", d);
		request.setAttribute("iList", iList);
		request.setAttribute("cList", cList);
		request.setAttribute("likeYN", likeYN);
		request.setAttribute("bookmarkYN", bookmarkYN);
		request.setAttribute("likeCount", likeCount);
		request.setAttribute("bookmarkCount", bookmarkCount);
>>>>>>>> feature/mypage/daily:src/com/stylecast/daily/controller/dailyDetailController.java
		request.getRequestDispatcher("views/daily/dailyDetailView.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
