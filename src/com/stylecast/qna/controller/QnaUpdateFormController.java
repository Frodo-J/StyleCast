package com.stylecast.qna.controller;

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
import com.stylecast.qna.model.service.QnaService;
import com.stylecast.qna.model.vo.Qna;

/**
 * Servlet implementation class QnaUpdateFormController
 */
@WebServlet("/updateForm.qna")
public class QnaUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaUpdateFormController() {
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
		
		int qnaNo = Integer.parseInt(request.getParameter("qno"));
		
		Qna q = new QnaService().selectQna(qnaNo);
		
		if((loginUser != null && loginUser.getAdminYN().equals("Y")) || (loginUser != null && loginUser.getMemName().equals(q.getMemName()))) {
			ArrayList<BoardImage> list = new QnaService().selectBoardImageList(qnaNo);
			
			request.setAttribute("list", list);
			request.setAttribute("q", q);
			
			request.getRequestDispatcher("views/qna/qnaUpdate.jsp").forward(request, response);
		}else {
			session.setAttribute("alertMsg", "부적절한 접근입니다.");
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
