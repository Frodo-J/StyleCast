package com.stylecast.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.stylecast.admin.model.service.AdminService;
import com.stylecast.admin.model.vo.Codi;
import com.stylecast.common.MyFileRenamePolicy;

/**
 * Servlet implementation class CodiInsertController
 */
@WebServlet("/enrollForm.co")
public class CodiInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodiInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int maxSize = 10 * 1024 * 1024;
		
		String savePath = request.getSession().getServletContext().getRealPath("/resources/codi_upfiles/");
		
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
		Codi c = new Codi();
		c.setGender(multiRequest.getParameter("gender"));
		c.setImgPath(multiRequest.getParameter("imgPath"));
		c.setRecWeather(multiRequest.getParameter("weather"));
		c.setRecLowT (multiRequest.getParameter("lowT"));
		c.setRecHighT (multiRequest.getParameter("highT"));
		
//		String gender = request.getParameter("gender");
//		String weather = request.getParameter("weather");
//		int lowT = Integer.parseInt(request.getParameter("lowT"));
//		int highT = Integer.parseInt(request.getParameter("highT"));
//		String imgPath = request.getParameter("imgPath");
		
//		System.out.println(gender);
//		System.out.println(weather);
//		System.out.println(lowT);
//		System.out.println(highT);
//		System.out.println(imgPath);
		
		int result = new AdminService().insertCodi(c);
		
		response.sendRedirect("/codilist.ad?currentPage=1");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
