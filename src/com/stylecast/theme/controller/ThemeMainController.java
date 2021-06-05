package com.stylecast.theme.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stylecast.daily.model.vo.Daily;
import com.stylecast.member.service.MemberService;
import com.stylecast.member.vo.Member;
import com.stylecast.theme.model.service.ThemeService;
import com.stylecast.theme.model.vo.Theme;
import com.stylecast.theme.model.vo.ThemePost;

/**
 * Servlet implementation class ThemeMainController
 */
@WebServlet("/list.th")
public class ThemeMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemeMainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	
		Theme t = new ThemeService().selectThemeMonthly();

		ArrayList<Daily> lList = null;
		
		if(session.getAttribute("loginUser") == null) { // 로그인 전
			lList = new ArrayList<Daily>();
			
		}else { // 로그인 후
			Member loginUser = (Member)session.getAttribute("loginUser");
			int memNo = loginUser.getMemNo();
			lList = new MemberService().selectMyLikeList(memNo);
		}
		
		int tno = t.getThemeNo();
		ArrayList<ThemePost> plist = new ThemeService().selectThemePost(tno);
		
		ArrayList<Theme> tlist = new ThemeService().selectThemeList(); 
		
		request.setAttribute("t", t);
		request.setAttribute("lList", lList);
		request.setAttribute("plist", plist);
		request.setAttribute("tlist", tlist);
		request.getRequestDispatcher("views/trending/trendingMainView.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
