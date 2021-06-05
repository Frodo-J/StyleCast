package com.stylecast.theme.controller;

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
import com.stylecast.daily.model.vo.Item;
import com.stylecast.member.vo.Member;
import com.stylecast.theme.model.service.ThemeService;
import com.stylecast.theme.model.vo.Theme;

/**
 * Servlet implementation class ThemeDetailController
 */
@WebServlet("/detail.th")
public class ThemeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemeDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    HttpSession session = request.getSession();
		
		Member loginUser = (Member)session.getAttribute("loginUser");

		int dno = Integer.parseInt(request.getParameter("dno"));
		int tno = Integer.parseInt(request.getParameter("tno"));
		
		Daily d = new DailyService().selectDailyDetail(dno);
		Theme m = new ThemeService().selectThemeInfo(tno);
		ArrayList<Item> iList = new DailyService().selectDailyItem(dno);
		ArrayList<Daily> dlist = new ThemeService().selectOtherPost(dno, tno);
		
		int likeYN = 0;
		int bookmarkYN = 0;
		
		int likeCount = new DailyService().selectLikedCount(dno);
		int bookmarkCount = new DailyService().selectBookmarkCount(dno);
		
		if(loginUser != null) {
			
			int memNo = loginUser.getMemNo();
			
			likeYN = new DailyService().checkLiked(memNo, dno);
			bookmarkYN = new DailyService().checkBookmark(memNo, dno);
		}
		
		request.setAttribute("d", d);
		request.setAttribute("m", m);
		request.setAttribute("iList", iList);
		request.setAttribute("dlist", dlist);
		request.setAttribute("likeYN", likeYN);
		request.setAttribute("bookmarkYN", bookmarkYN);
		request.setAttribute("likeCount", likeCount);
		request.setAttribute("bookmarkCount", bookmarkCount);
		request.getRequestDispatcher("views/trending/trendingDetailView.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
