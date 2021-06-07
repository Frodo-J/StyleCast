package com.stylecast.daily.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stylecast.daily.model.service.DailyService;
import com.stylecast.daily.model.vo.DailyCM;
import com.stylecast.daily.model.vo.Report;

/**
 * Servlet implementation class CommentDeleteController
 */
@WebServlet("/cdelete.da")
public class CommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int dailyNo = Integer.parseInt(request.getParameter("dailyNo"));
		int cmNo = Integer.parseInt(request.getParameter("cmNo"));
		String currentUrl = request.getParameter("currentUrl");
		
		DailyCM cm = new DailyCM();
		cm.setDailyNo(dailyNo);
		cm.setCmNo(cmNo);
		
		System.out.println(dailyNo);
		System.out.println(cmNo);
		
		Report r = new DailyService().checkReportCM(cm);
		System.out.println(r);
		if(r != null) {
			request.getSession().setAttribute("alertMsg", "신고가 접수된 댓글은 삭제할 수 없습니다. 관리자에게 문의 바랍니다.");
			response.sendRedirect(currentUrl);			
		}else {
			int result = new DailyService().deleteDailyCM(cm);
			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "댓글이 성공적으로 삭제되었습니다.");
				response.sendRedirect(currentUrl);			
			}else {
				request.setAttribute("errorMsg", "댓글 삭제를 실패하였습니다.");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
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
