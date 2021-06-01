package com.stylecast.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stylecast.member.vo.Member;
import com.stylecast.qna.model.service.QnaService;
import com.stylecast.qna.model.vo.Qna;

/**
 * Servlet implementation class AnswerInsertController
 */
@WebServlet("/ainsert.qna")
public class AnswerInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String content = request.getParameter("content");
		int qnaNo = Integer.parseInt(request.getParameter("qno"));
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		
		Qna qnaAnswer = new Qna();
		qnaAnswer.setAnsContent(content);
		qnaAnswer.setMemAdmin(userNo);
		qnaAnswer.setQnaNo(qnaNo);
		
		int result = new QnaService().updateQnaAnswer(qnaAnswer);
		System.out.println("controller:" + result);
		
		response.getWriter().print(result);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
