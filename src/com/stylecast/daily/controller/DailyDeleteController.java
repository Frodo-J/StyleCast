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
 * Servlet implementation class DailyDeleteController
 */
@WebServlet("/delete.da")
public class DailyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DailyDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int dno = Integer.parseInt(request.getParameter("dno"));
		
		Report r = new DailyService().checkReportDaily(dno);
		
		if(r != null) {
			request.getSession().setAttribute("alertMsg", "신고가 접수되었거나, 신고 접수된 댓글이 포함된 게시글은 삭제할 수 없습니다. 관리자에게 문의 바랍니다.");
			response.sendRedirect(request.getContextPath() + "/detail.da?dno=" + dno);			
		}else {
			int result = new DailyService().deleteDaily(dno);
			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "게시글이 성공적으로 삭제되었습니다.");
				response.sendRedirect(request.getContextPath() + "/list.da?currentPage=1");			
			}else {
				request.setAttribute("errorMsg", "게시글 삭제를 실패하였습니다.");
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
