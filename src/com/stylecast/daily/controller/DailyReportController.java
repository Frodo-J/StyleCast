package com.stylecast.daily.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stylecast.daily.model.service.DailyService;
import com.stylecast.daily.model.vo.Report;

/**
 * Servlet implementation class DailyReportController
 */
@WebServlet("/report.da")
public class DailyReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DailyReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		//int memNo = Integer.parseInt(request.getParameter("memNo"));
		int rMemNo = Integer.parseInt(request.getParameter("rMemNo"));
		int dailyNo = Integer.parseInt(request.getParameter("dailyNo"));
		String rptCategory = request.getParameter("report_category");
		String content = request.getParameter("report_text"); 
		String currentUrl = request.getParameter("currentUrl");
		
		Report r = new Report();
		//r.setMemNo(memNo);
		r.setrMemNo(rMemNo);
		r.setDailyNo(dailyNo);
		r.setContent(content);
		r.setRptCategory(rptCategory);
		
		int result = new DailyService().insertReportDaily(r);
		
		if(result > 0) {
			
			request.getSession().setAttribute("alertMsg", "성공적으로 신고가 접수되었습니다.");
			response.sendRedirect(currentUrl);			
			
		}else {
			request.setAttribute("errorMsg", "신고 접수를 실패하였습니다.");
			
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
