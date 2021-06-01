package com.stylecast.daily.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stylecast.daily.model.service.DailyService;
import com.stylecast.daily.model.vo.DailyCM;
import com.stylecast.member.vo.Member;

/**
 * Servlet implementation class AjaxCommentInsertController
 */
@WebServlet("/cinsert.da")
public class AjaxCommentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxCommentInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cmContent = request.getParameter("content");
		int dailyNo = Integer.parseInt(request.getParameter("dno"));
		int memNo = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		
		DailyCM cm = new DailyCM();
		cm.setCmContent(cmContent);
		cm.setDailyNo(dailyNo);
		cm.setMemNo(memNo);
		
		int result = new DailyService().insertDailyCM(cm);
	
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
