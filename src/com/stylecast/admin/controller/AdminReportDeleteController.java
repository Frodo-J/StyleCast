package com.stylecast.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stylecast.admin.model.service.AdminService;

/**
 * Servlet implementation class AdminReportDeleteController
 */
@WebServlet("/rptDelete.adm")
public class AdminReportDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReportDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String[] rptNoArr = request.getParameterValues("rptNo");
		
		int result = new AdminService().deleteReport(rptNoArr);
		
		if(result > 0) { // 삭제 실패 => 에러페이지 응답

			session.setAttribute("alertMsg", "신고글을 삭제했습니다.");
			response.sendRedirect(request.getContextPath() + "/rptList.adm?brCategory=0");
		
			
		}else { // 로그인 성공 => mainPage 응답
			
			session.setAttribute("alertMsg", "신고글 삭제에 실패했습니다.");
			response.sendRedirect(request.getContextPath() + "/rptList.adm?brCategory=0");
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
