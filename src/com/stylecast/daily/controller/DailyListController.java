package com.stylecast.daily.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.daily.model.service.DailyService;
import com.stylecast.daily.model.vo.Daily;
import com.stylecast.member.service.MemberService;
import com.stylecast.member.vo.Member;

/**
 * Servlet implementation class DailyListController
 */
@WebServlet("/list.da")
public class DailyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DailyListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;

		listCount = new DailyService().selectListCount();
		currentPage = Integer.parseInt(request.getParameter("currentPage"));

		pageLimit = 10;
		boardLimit = 8;

		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit -1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);

		ArrayList<Daily> list = new DailyService().selectDailyList(pi);
		
		int[] likeCount = new DailyService().selectLikedCountList(pi);
		int[] bookmarkCount = new DailyService().selectBookmarkCountList(pi);
		
		int i = 0;
		
		for(Daily d : list) {
			d.setLikeCount(likeCount[i]);
			d.setBookmarkCount(bookmarkCount[i]);;
			i++;
		}
		
		ArrayList<Daily> bList = null;
		ArrayList<Daily> lList = null;
		
		if(session.getAttribute("loginUser") == null) { // 로그인 전
			bList = new ArrayList<Daily>();
			lList = new ArrayList<Daily>();
		}else { // 로그인 후
			
			Member loginUser = (Member)session.getAttribute("loginUser");
			int memNo = loginUser.getMemNo();
			
			bList = new MemberService().selectMyBookmarkList(memNo);
			lList = new MemberService().selectMyLikeList(memNo);
		}
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.setAttribute("bList", bList);
		request.setAttribute("lList", lList);
		
		request.getRequestDispatcher("views/daily/dailyListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
