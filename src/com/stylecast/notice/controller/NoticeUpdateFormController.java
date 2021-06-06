package com.stylecast.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stylecast.common.model.vo.BoardImage;
import com.stylecast.member.vo.Member;
import com.stylecast.notice.model.service.NoticeService;
import com.stylecast.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateFormController
 */
@WebServlet("/updateForm.no")
public class NoticeUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		if(loginUser != null && loginUser.getAdminYN().equals("Y")) {
			int noticeNo = Integer.parseInt(request.getParameter("nno"));
		
			Notice n = new NoticeService().selectNotice(noticeNo);
		
			ArrayList<BoardImage> list = new NoticeService().selectBoardImageList(noticeNo);
		
			request.setAttribute("list", list);
			request.setAttribute("n", n);
		
			request.getRequestDispatcher("views/notice/noticeUpdate.jsp").forward(request, response);
		}else{
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
