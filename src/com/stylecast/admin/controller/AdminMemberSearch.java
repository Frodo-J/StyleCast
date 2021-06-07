package com.stylecast.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stylecast.admin.model.service.AdminService;
import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.member.vo.Member;


/**
 * Servlet implementation class AdminMemberSearch
 */
@WebServlet("/memsearch.adm")
public class AdminMemberSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberSearch() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		// 여기서 작업
		// 블랙 유뮤
		//String blackListYN = request.getParameter("blackListYN");
		
		//사용자가 선택한 카테고리
		String category = request.getParameter("search_category");
		
		//사용자가 입력한 검색내용
		String text = request.getParameter("search_text");
		
		// 총 게시글 갯수
		listCount = new AdminService().selectSearchListCount(category,text);
		
		// 사용자가 요청한 페이지 ( 현재 페이지)
	    currentPage = Integer.parseInt(request.getParameter("currentPage"));

		
		// pageLimit : 하단에 보여질 페이징바의 페이지 최대 갯수(페이지 목록들 몇개)
		pageLimit = 10;
		
		// boardLimit : 한 페이지 내에 보여질 게시글 최대 갯수
		boardLimit = 10;
		
		//maxPage : 제일 마지막 페이지수 ( 총 페이지 수)
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
				
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		if(loginUser != null && loginUser.getAdminYN().equals("Y")) {
		
			ArrayList<Member> list = new AdminService().selectSearchList(pi,category,text);
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("text", text);
			request.setAttribute("category", category);
			
			request.getRequestDispatcher("views/admin/adminMemberSearch.jsp").forward(request,response);
		}else {
			session.setAttribute("alertMsg", "관리자만 접근 가능한 페이지입니다.");
			response.sendRedirect(request.getContextPath());
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
