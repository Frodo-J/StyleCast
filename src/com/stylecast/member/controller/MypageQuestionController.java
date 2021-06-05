package com.stylecast.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stylecast.common.model.vo.PageInfo;
import com.stylecast.member.vo.Member;
import com.stylecast.qna.model.service.QnaService;
import com.stylecast.qna.model.vo.Qna;

/**
 * Servlet implementation class mypageQuestionController
 */
@WebServlet("/question.me")
public class MypageQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageQuestionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// 페이징바용 변수 선언
		int listCount; // 현재 총 게시글 갯수
		int currentPage; // 현재 페이지 (사용자가 요청한 페이지)
		int pageLimit; // 페이지 하단에 보여질 페이징바의 페이지 최대 갯수 (페이지 단위)
		int boardLimit; // 한 페이지 내에 보여질 게시글 최대 갯수 (게시글수 단위)
		
		int maxPage; // 가장 마지막 페이지 (총 페이지 수)
		int startPage; // 페이지 하단에 보여질 페이징바의 시작수
		int endPage; // 페이지 하단에 보여질 페이징바의 끝수
		
		// 로그인한 회원의 요청인지 확인
		if(session.getAttribute("loginUser") == null) { // 로그인 전
			
			session.setAttribute("alertMsg", "로그인 후 이용가능한 서비스입니다.");
			response.sendRedirect(request.getContextPath());
			
		}else { // 로그인 후
			
			Member loginUser = (Member)session.getAttribute("loginUser");
			int memNo = loginUser.getMemNo();
			
			// 페이지바용 변수 값 담기
			listCount = new QnaService().selectMyQnaListCount(memNo);
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			pageLimit = 10;
			boardLimit = 10;
			maxPage = (int)Math.ceil((double)listCount / boardLimit);
			startPage = (currentPage-1) / pageLimit * pageLimit + 1;
			endPage = startPage + pageLimit - 1;
			if(endPage > maxPage) {
				endPage = maxPage;
			}
			
			PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
			
			// 질문글 전체 조회
			ArrayList<Qna> list = new QnaService().selectMyQnaList(memNo, pi);
			
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/mypage/mypageQuestion.jsp").forward(request, response);
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
