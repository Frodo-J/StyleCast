package com.stylecast.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stylecast.admin.model.service.AdminService;
import com.stylecast.theme.model.vo.Theme;

/**
 * Servlet implementation class AdminTrendingInsertController
 */
@WebServlet("/insert.tr")
public class AdminTrendingInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTrendingInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String subtitle = request.getParameter("month") + "월 " + request.getParameter("week") + "주차";
		String status = request.getParameter("status");
		String color = request.getParameter("color");
	
		Theme t = new Theme();
		t.setThemeTitle(title);
		t.setThemeSubtitle(subtitle);
		t.setStatus(status);
		t.setThemeTitleColor(color);
		
		int result = new AdminService().insertTheme(t);
		
		if(result > 0) {
			int tno = result;
			request.getSession().setAttribute("alertMsg", "성공적으로 테마가 작성되었습니다.");
			response.sendRedirect(request.getContextPath() + "/modifyForm.tr?tno=" + tno);
			
		}else {
			request.setAttribute("errorMsg", "테마 작성을 실패하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
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
