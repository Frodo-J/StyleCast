package com.stylecast.admin.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.stylecast.admin.model.service.AdminService;
import com.stylecast.admin.model.vo.Codi;
import com.stylecast.common.MyFileRenamePolicy;

/**
 * Servlet implementation class CodiDeleteController
 */
@WebServlet("/codidelete.ad")
public class CodiDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodiDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int maxSize = 10 * 1024 * 1024;
		
		String savePath = request.getSession().getServletContext().getRealPath("/resources/codi_upfiles/");
		
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
		int cno = Integer.parseInt(multiRequest.getParameter("cno"));
		HttpSession session = request.getSession();
		
		Codi c = new Codi();
		c.setCodiNo(cno);
		
		int result = new AdminService().selectCodiDelete(c);
		if(result>0) {
			response.sendRedirect(request.getContextPath() + "/codilist.ad?currentPage=1");
			session.setAttribute("alertMsg", "코디 삭제를 성공하였습니다");
		}else {
			session.setAttribute("alertMsg", "코디 삭제를 실패하였습니다");
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
